import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9328_열쇠 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T, H, W;
    static char[][] map;
    static boolean[] key;
    static boolean[][] visited;
    static int result;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H + 2][W + 2];
            visited = new boolean[H + 2][W + 2];
            key = new boolean[26];
            result = 0;

            for (int i = 1; i <= H; i++) {
                String str = br.readLine();
                for (int j = 1; j <= W; j++) {
                    map[i][j] = str.charAt(j - 1);
                }
            }

            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '0') {
                    key[str.charAt(i) - 'a'] = true;
                }
            }

            bfs();
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nc < 0 || nc >= W + 2 || nr < 0 || nr >= H + 2 || map[nr][nc] == '*' || visited[nr][nc]) {
                    continue;
                }

                if ('A' <= map[nr][nc] && map[nr][nc] <= 'Z') {
                    if (!key[map[nr][nc] - 'A']) {
                        continue;
                    }
                } else if ('a' <= map[nr][nc] && map[nr][nc] <= 'z') {
                    if (!key[map[nr][nc] - 'a']) {
                        key[map[nr][nc] - 'a'] = true;
                        visited = new boolean[H + 2][W + 2];
                    }
                } else if (map[nr][nc] == '$') {
                    result++;
                }

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}