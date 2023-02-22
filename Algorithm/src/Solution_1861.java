import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int N;
    private static int[] dx;
    private static int[] dy;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dy = new int[]{-1, 1, 0, 0};
            dx = new int[]{0, 0, -1, 1};
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] answer = new int[2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int[] bfs = bfs(i, j);
                    if (answer[1] < bfs[1]) {
                        answer[0] = bfs[0];
                        answer[1] = bfs[1];
                    } else if (answer[1] == bfs[1]) {
                        if (answer[0] > bfs[0]) answer[0] = bfs[0];
                    }
                }
            }
            bw.write("#" + tc + " " + answer[0] + " " + answer[1] + "\n");
        }
        bw.close();
    }

    static int[] bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        int cnt = 1;
        int num = map[x][y];
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if (map[ny][nx] == map[poll[0]][poll[1]] + 1) {
                    q.add(new int[]{ny, nx});
                    cnt++;
                    break;
                }
            }
        }
        return new int[]{num, cnt};

    }
}
