import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static int max = 0;
    static int result = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();

            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
                max = Math.max(map[i][j], max);
            }
        }

        for (int h = 1; h <= max; h++) {
            map[0][0] = h;

            Queue<Pair> q = new ArrayDeque<>();
            q.add(new Pair(0, 0));

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx > N + 1 || ny > M + 1) continue;
                    if (map[nx][ny] >= h) continue;
                    map[nx][ny] = h;
                    q.add(new Pair(nx, ny));
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] < h) {
                        result++;
                        map[i][j] += 1;
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}