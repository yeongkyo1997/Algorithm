import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
            if (room[nx][ny] == 0) {
                return new int[]{nx, ny};
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][N];
        visited = new boolean[N][N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0, 0});
        visited[0][0][0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int day = cur[2];
            int move = cur[3];
            int su = cur[4];
            if (x == N - 1 && y == N - 1) {
                if (su == 0) {
                    bw.write(day + " sun");
                } else {
                    bw.write(day + " moon");
                }
                bw.flush();
                bw.close();
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                //이동하고나서 낮과 밤이 바뀐다
                //but이동중에는 아직 안바뀌는 걸 명시해야함

                //그냥 이동
                if (room[nx][ny] == 0) {
                    int next_move = move + 1;
                    int n_su = su;
                    int next_day = day;
                    if (next_move == M) {
                        next_move = 0;
                        n_su = n_su + 1;
                        if (n_su == 2) {
                            n_su = 0;
                            next_day += 1;
                        }
                    }
                    if (!visited[nx][ny][next_move][n_su]) {
                        q.add(new int[]{nx, ny, next_day, next_move, n_su});
                        visited[nx][ny][next_move][n_su] = true;
                    }
                }

                //벽을 넘는 경우
                if ((su == 1) && room[nx][ny] == 1) {
                    int[] next = mov(nx, ny, d);
                    int px = next[0];
                    int py = next[1];
                    if (room[px][py] == 1) {
                        continue;
                    }
                    int next_move = move + 1;
                    int n_su = 1;
                    int next_day = day;
                    if (next_move == M) {
                        next_move = 0;
                        n_su = 0;
                        next_day = next_day + 1;
                    }
                    if (!visited[px][py][next_move][n_su]) {
                        q.add(new int[]{px, py, next_day, next_move, n_su});
                        visited[px][py][next_move][n_su] = true;
                    }
                }
            }
        }
        bw.write(-1 + "");
        bw.flush();
        bw.close();
    }
}