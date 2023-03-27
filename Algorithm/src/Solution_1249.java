import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1249 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    private static int N;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            bw.write(String.format("#%d %d\n", t + 1, bfs(0, 0)));
        }
        bw.close();
    }

    static int bfs(int x, int y) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
        queue.add(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N - 1 && cur[1] == N - 1) return cur[2];
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cur[2] + map[nx][ny]});
                }
            }
        }
        return -1;
    }
}
