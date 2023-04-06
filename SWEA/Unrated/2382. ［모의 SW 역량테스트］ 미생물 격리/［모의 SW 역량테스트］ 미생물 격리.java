import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, K;
    static int dx[] = {0, -1, 1, 0, 0};
    static int dy[] = {0, 0, 0, -1, 1};
    static int[][] data;
    static int[][][] map, copy;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            data = new int[N][4];
            map = new int[N + 1][N + 1][3];
            copy = new int[N + 1][N + 1][3];

            int x = 0, y = 0, w = 0, d = 0;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                map[x][y][0] = w;
                map[x][y][1] = d;

            }

            for (int i = 0; i < M; i++) {
                copy = new int[N + 1][N + 1][3];
                micro();
                copym();
            }

            int ans = 0;
            for (int i = 0; i < N + 1; i++) {
                for (int j = 0; j < N + 1; j++) {
                    ans += map[i][j][0];
                }
            }
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    private static void micro() {
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (map[i][j][0] == 0) continue;

                int nx = i + dx[map[i][j][1]];
                int ny = j + dy[map[i][j][1]];

                if (nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
                    copy[nx][ny][0] = map[i][j][0] / 2;
                    if (map[i][j][1] % 2 == 0) copy[nx][ny][1] = map[i][j][1] - 1;
                    else copy[nx][ny][1] = map[i][j][1] + 1;
                } else {

                    if (copy[nx][ny][2] == 0) copy[nx][ny][2] = copy[nx][ny][0];
                    if (copy[nx][ny][2] < map[i][j][0]) {
                        copy[nx][ny][2] = map[i][j][0];
                        copy[nx][ny][1] = map[i][j][1];
                    }
                    copy[nx][ny][0] += map[i][j][0];
                }
            }
        }

    }

    private static void copym() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    if (copy[i][j][0] == 0) copy[i][j][1] = copy[i][j][2] = 0;
                    map[i][j][k] = copy[i][j][k];
                }
            }
        }
    }
}