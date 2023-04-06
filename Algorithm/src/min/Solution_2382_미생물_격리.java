package min;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_2382_미생물_격리 {
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
//            for (int i = 0; i < N + 1; i++) {
//                for (int j = 0; j < N + 1; j++) {
//                    System.out.print(map[i][j][0] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            for (int i = 0; i < M; i++) {
//                System.out.println("c" + i);
                copy = new int[N + 1][N + 1][3];
                micro();
                map = new int[N + 1][N + 1][3];
                copym();
            }

            int ans = 0;
            for (int i = 0; i < N + 1; i++) {
                for (int j = 0; j < N + 1; j++) {
                    ans += map[i][j][0];
                }
            }
//            System.out.println("#" + t + " " + ans);
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    private static void micro() {
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                // 미생물이 없으면 다음 칸
                if (map[i][j][0] == 0) continue;

                int nx = i + dx[map[i][j][1]];
                int ny = j + dy[map[i][j][1]];

                if (nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
                    // 경계선에 걸치면 반 줄이고 방향 바꾸기
                    copy[nx][ny][0] = map[i][j][0] / 2;
//                        copy[nx][ny][0] = map[i][j][2] / 2;
                    if (map[i][j][1] % 2 == 0) copy[nx][ny][1] = map[i][j][1] - 1;
                    else copy[nx][ny][1] = map[i][j][1] + 1;
                } else {
                    // 안걸치면
                    // 늦게 온 미생물이 더 많으면 늦게온 미생물 방향 주기
                    if (copy[nx][ny][2] == 0) copy[nx][ny][2] = copy[nx][ny][0];

                    if (copy[nx][ny][2] < map[i][j][0]) {
                        copy[nx][ny][2] = map[i][j][0];
                        copy[nx][ny][1] = map[i][j][1];
                    }
                    copy[nx][ny][0] += map[i][j][0];
                }
//                    System.out.println("d" + copy[nx][ny][1] + " " + copy[nx][ny][0]);
//                    for (int x = 0; x < N + 1; x++) {
//                        for (int y = 0; y < N + 1; y++) {
//                            System.out.print(copy[x][y][0] + " ");
//                        }
//                        System.out.println();
//                    }
//                    System.out.println();
            }
        }

    }

    private static void copym() {
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                for (int k = 0; k < 3; k++) {
                    map[i][j][k] = copy[i][j][k];
                }
            }
        }
    }
}