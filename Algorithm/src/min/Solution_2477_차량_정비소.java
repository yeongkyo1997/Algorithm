package min;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_2477_차량_정비소 {
    static int N, M, K, A, B;
    static int[][] tN, tM;
    static int[][] tK;
    static boolean[] vN, vM;

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
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            int ans = 0;

            tN = new int[N][2];
            tM = new int[M][2];
            tK = new int[K][3];
            vN = new boolean[N];
            vM = new boolean[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                tN[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                tM[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                tK[i][0] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                reception(i);
            }
            for (int i = 0; i < K; i++) {
                if (tK[i][1] + 1 == A && tK[i][2] + 1 == B) ans += (i + 1);
            }

            System.out.println(ans);
        }
    }

    private static void reception(int num) {
        for (int i = 0; i < N; i++) {
            if (tN[i][1] <= tK[num][0]) { // 손님이 도착한 시간이 접수 가능한 시간보다 큰 경우
                tK[num][1] = i; // 손님 배열에 접수 창구 입력
                tN[i][1] += (tK[num][0] + tN[i][0]); // 접수 창구 시간 증가
                tK[num][0] += tN[i][0];
                repair(num);
            }
            tK[num][0]++; // 손님 시간 증가
        }
    }

    private static void repair(int num) {
        for (int i = 0; i < M; i++) {
            if (tM[i][1] <= tK[num][0]) {// 손님이 도착한 시간이 수리 가능한 시간보다 큰 경우
                tK[num][2] = i;
                tM[i][1] += (tK[num][0] + tM[i][0]);
                tK[num][0] += tN[i][0];
            }
            tK[num][0]++;
        }
    }
}