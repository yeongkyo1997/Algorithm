import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18224_미로에_갇힌_건우 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] room;
    static boolean[][][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    static int[] mov(int x, int y, int d) {
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                nx -= dx[d];
                ny -= dy[d];
                return new int[]{nx, ny};
            }

            if (room[nx][ny] == 0) return new int[]{nx, ny};
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][N];

        visited = new boolean[N][N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) room[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0, 0});
        visited[0][0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int day = cur[2];
            int move = cur[3];
            int sun = cur[4];

            if (x == N - 1 && y == N - 1) {
                if (sun == 0) bw.write(day + " sun");
                else bw.write(day + " moon");

                bw.flush();
                bw.close();
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;


                if (room[nx][ny] == 0) {
                    int nMove = move + 1;
                    int nSun = sun;
                    int nDay = day;

                    if (nMove == M) {
                        nMove = 0;
                        nSun = nSun + 1;

                        if (nSun == 2) {
                            nSun = 0;
                            nDay += 1;
                        }
                    }
                    if (!visited[nx][ny][nMove][nSun]) {
                        queue.add(new int[]{nx, ny, nDay, nMove, nSun});
                        visited[nx][ny][nMove][nSun] = true;
                    }
                }

                if ((sun == 1) && room[nx][ny] == 1) {
                    int[] next = mov(nx, ny, d);
                    int px = next[0];
                    int py = next[1];
                    if (room[px][py] == 1) continue;

                    int nMove = move + 1;
                    int nSun = 1;
                    int nDay = day;
                    if (nMove == M) {
                        nMove = 0;
                        nSun = 0;
                        nDay = nDay + 1;
                    }
                    if (!visited[px][py][nMove][nSun]) {
                        queue.add(new int[]{px, py, nDay, nMove, nSun});
                        visited[px][py][nMove][nSun] = true;
                    }
                }
            }
        }
        bw.write(-1 + "");
        bw.flush();
        bw.close();
    }
}