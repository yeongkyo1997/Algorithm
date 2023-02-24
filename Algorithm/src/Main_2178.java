import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bw.write(bfs() + "");
        bw.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});
        map[0][0] = 0;


        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) return cur[2];


            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int ndepth = cur[2] + 1;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    queue.add(new int[]{nx, ny, ndepth});
                }
            }
        }
        return -1;
    }
}


