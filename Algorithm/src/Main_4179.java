import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 4179번 불!
public class Main_4179 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int R;
    static int C;
    static char[][] map;
    static int[][] f;
    static int[][] J;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        f = new int[R][C];
        J = new int[R][C];
        int x = 0;
        int y = 0;
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'F') f[i][j] = 1;
                else if (map[i][j] == 'J') {
                    J[i][j] = 1;
                    x = i;
                    y = j;
                }
            }
        }
        fBfs();
        jBfs(x, y);
        bw.close();
    }

    static void fBfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (f[i][j] == 1) queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (f[nx][ny] == 0 && map[nx][ny] != '#') {
                    f[nx][ny] = f[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    static void jBfs(int x, int y) throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int a = temp[0];
            int b = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    bw.write(J[a][b] + "");
                    return;
                } else {
                    if (J[nx][ny] != 0 || map[nx][ny] == '#' || (f[nx][ny] != 0 && f[nx][ny] <= J[a][b] + 1)) continue;
                    J[nx][ny] = J[a][b] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        bw.write("IMPOSSIBLE");
    }
}
