import java.io.*;
import java.util.StringTokenizer;

// SW Expert Academy 2115. 벌꿀채취
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] map = new int[11][11];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int[] list = new int[M];
                    for (int k = 0; k < M; k++) {
                        list[k] = map[i][j + k];
                    }
                    int[] sub = new int[1 << M];
                    for (int k = 1; k < (1 << M); k++) {
                        int sum = 0;
                        int cnt = 0;
                        for (int l = 0; l < M; l++) {
                            if ((k & (1 << l)) != 0) {
                                sum += list[l];
                                cnt += list[l] * list[l];
                            }
                        }
                        if (sum <= C) sub[k] = cnt;
                    }
                    int max1 = 0;
                    for (int k = 1; k < (1 << M); k++) {
                        if (max1 < sub[k]) max1 = sub[k];
                    }
                    for (int k = i; k < N; k++) {
                        int start = 0;
                        if (i == k) start = j + M;
                        for (int l = start; l <= N - M; l++) {
                            int[] list2 = new int[M];
                            for (int m = 0; m < M; m++) {
                                list2[m] = map[k][l + m];
                            }
                            int[] sub2 = new int[1 << M];
                            for (int m = 1; m < (1 << M); m++) {
                                int sum = 0;
                                int cnt = 0;
                                for (int n = 0; n < M; n++) {
                                    if ((m & (1 << n)) != 0) {
                                        sum += list2[n];
                                        cnt += list2[n] * list2[n];
                                    }
                                }
                                if (sum <= C) sub2[m] = cnt;
                            }
                            int max2 = 0;
                            for (int m = 1; m < (1 << M); m++) {
                                if (max2 < sub2[m]) max2 = sub2[m];
                            }
                            if (max < max1 + max2) max = max1 + max2;
                        }
                    }
                }
            }
            bw.write("#" + tc + " " + max + "\n");
        }
        bw.close();
    }
}