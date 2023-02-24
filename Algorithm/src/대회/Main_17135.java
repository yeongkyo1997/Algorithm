package 대회;

import java.io.*;
import java.util.StringTokenizer;

// 캐슬 디펜스
public class Main_17135 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M, D, result;
    static int[][] map;
    static int[] archer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        archer = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);

        bw.write(result + "");
        bw.close();

    }

    static void combi(int depth, int flag) {
        if (depth == 3) {
            int[][] copy = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copy[i][j] = map[i][j];
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    int min = Integer.MAX_VALUE;
                    int x = 0, y = 0;
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < M; l++) {
                            if (copy[k][l] == 1) {
                                int dist = Math.abs(N - k) + Math.abs(archer[j] - l);
                                if (dist <= D) {
                                    if (min > dist) {
                                        min = dist;
                                        x = k;
                                        y = l;
                                    } else if (min == dist) {
                                        if (y > l) {
                                            x = k;
                                            y = l;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (min != Integer.MAX_VALUE) {
                        if (copy[x][y] == 1) {
                            copy[x][y] = 0;
                            cnt++;
                        }
                    }
                }
                for (int j = 0; j < M; j++) {
                    if (copy[N - 1][j] == 1) {
                        copy[N - 1][j] = 0;
                    }
                }
                for (int j = N - 2; j >= 0; j--) {
                    for (int k = 0; k < M; k++) {
                        copy[j + 1][k] = copy[j][k];
                    }
                }
                for (int j = 0; j < M; j++) {
                    copy[0][j] = 0;
                }
            }
            result = Math.max(result, cnt);
            return;
        }

        for (int i = 0; i < M; i++) {
            if ((flag & 1 << i) != 0) continue;
            archer[depth] = i;

            combi(depth + 1, flag | 1 << i);
        }
    }
}


