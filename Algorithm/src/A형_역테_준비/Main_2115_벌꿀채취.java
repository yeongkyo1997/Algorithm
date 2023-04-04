package A형_역테_준비;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2115_벌꿀채취 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 벌통의 크기
            int M = Integer.parseInt(st.nextToken()); // 연속된 M개의 벌통
            int C = Integer.parseInt(st.nextToken()); // 채취할 수 있는 꿀의 최대 양
            int[][] map = new int[11][11]; // 벌통의 정보

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0; // 최대 수익
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int[] list = new int[M]; // M개의 벌통의 꿀 양
                    System.arraycopy(map[i], j, list, 0, M); // M개의 벌통의 꿀 양을 list에 복사

                    int[] sub = new int[1 << M]; // 부분집합

                    for (int k = 1; k < (1 << M); k++) { // 부분집합
                        int sum = 0; // 부분집합의 꿀 양
                        int cnt = 0; // 부분집합의 수익

                        for (int l = 0; l < M; l++) {
                            if ((k & (1 << l)) != 0) { // 부분집합에 포함되어 있으면
                                sum += list[l]; // 부분집합의 꿀 양에 더함
                                cnt += list[l] * list[l]; // 부분집합의 수익에 더함
                            }
                        }
                        if (sum <= C) sub[k] = cnt; // 부분집합의 수익을 저장
                    }

                    int max1 = 0; // 부분집합 중 최대 수익
                    for (int k = 1; k < (1 << M); k++) { // 부분집합 중 최대 수익 찾기
                        if (max1 < sub[k]) max1 = sub[k]; // 부분집합 중 최대 수익
                    }

                    for (int k = i; k < N; k++) {  // 다음 행부터
                        int start = 0; // 시작 열
                        if (i == k) start = j + M; // 같은 행이면 M만큼 더함

                        for (int l = start; l <= N - M; l++) { // 다음 행부터 M개의 벌통을 선택
                            int[] list2 = new int[M]; // M개의 벌통의 꿀 양

                            System.arraycopy(map[k], l, list2, 0, M); // M개의 벌통의 꿀 양을 list2에 복사

                            int[] sub2 = new int[1 << M]; // 부분집합

                            for (int m = 1; m < (1 << M); m++) { // 부분집합
                                int sum = 0; // 부분집합의 꿀 양
                                int cnt = 0; // 부분집합의 수익

                                for (int n = 0; n < M; n++) { // 부분집합에 포함되어 있으면
                                    if ((m & (1 << n)) != 0) { // 부분집합에 포함되어 있으면
                                        sum += list2[n]; // 부분집합의 꿀 양에 더함
                                        cnt += list2[n] * list2[n]; // 부분집합의 수익에 더함
                                    }
                                }

                                if (sum <= C) sub2[m] = cnt;  // 부분집합의 수익을 저장
                            }

                            int max2 = 0; // 부분집합 중 최대 수익

                            for (int m = 1; m < (1 << M); m++) { // 부분집합 중 최대 수익 찾기
                                if (max2 < sub2[m]) max2 = sub2[m]; // 부분집합 중 최대 수익
                            }

                            if (max < max1 + max2) max = max1 + max2; // 최대 수익
                        }
                    }
                }
            }
            bw.write("#" + t + " " + max + "\n");
        }
        bw.close();
    }
}