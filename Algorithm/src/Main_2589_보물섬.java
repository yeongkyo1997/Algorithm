import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    int tmp = bfs(i, j);
                    result = Math.max(tmp, result);
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, 0});
        visited = new boolean[N][M];
        visited[x][y] = true;
        int res = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            res = Math.max(cur[2], res);
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int ndepth = cur[2] + 1;

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 'L' && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, ndepth});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }
}