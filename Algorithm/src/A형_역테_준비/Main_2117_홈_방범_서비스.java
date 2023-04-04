package A형_역테_준비;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2117_홈_방범_서비스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T, N, M; // 테스트 케이스, 지도의 크기, 집의 최대 수익
    static int[][] map = new int[25][25]; // 지도
    static int[][][] area = new int[22][25 * 25][25 * 25]; // k 크기의 영역

    static int K; // 영역의 크기
    static int[] cost = new int[22];  // k 크기의 영역의 비용

    /*
     * k 크기의 영역을 만드는 함수
     */
    static void makeArea(int k) {
        cost[k] = k * k + (k - 1) * (k - 1); // k 크기의 영역의 비용

        /*
         * k 크기의 영역을 만들어서 area에 저장
         */
        for (int r = 1; r <= k; r++) { // k 크기의 영역을 만들어서 area에 저장
            for (int c = k + 1 - r; c <= k + r - 1; c++) {
                area[k][r][c] = 1; // k 크기의 영역을 만들어서 area에 저장
            }
        }

        /*
         * k 크기의 영역을 만들어서 area에 저장
         */
        for (int r = k + 1; r <= 2 * k - 1; r++) {
            for (int c = r - k + 1; c <= 3 * k - r - 1; c++) {
                area[k][r][c] = 1;
            }
        }
    }

    /*
     * sr, sc에서 k 크기의 영역을 스캔하는 함수
     * sr : 영역의 시작 행
     * sc : 영역의 시작 열
     */
    static int scan(int sr, int sc) {
        int sum = 0; // 영역의 집의 수

        for (int r = 1; r <= 2 * K - 1; r++) { // 영역의 집의 수를 구함
            for (int c = 1; c <= 2 * K - 1; c++) {
                if (sr + r < 1 || sr + r > N || sc + c < 1 || sc + c > N) continue; // 지도를 벗어나면 continue
                sum += map[sr + r][sc + c] * area[K][r][c]; // 영역의 집의 수를 구함
            }
        }

        return sum; // 영역의 집의 수를 반환
    }

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 21; i++) makeArea(i); // k 크기의 영역을 만듬

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            K = N + 1; // K의 최대값

            int areaNum, maxAreaNum; // 영역의 집의 수, 최대 영역의 집의 수

            maxAreaNum = 0; // 최대 영역의 집의 수

            /*
             * 1. K의 최대값을 구함
             * 2. K의 최대값부터 1까지 반복
             * 3. K 크기의 영역을 스캔
             * 4. K 크기의 영역의 집의 수가 0이 아니면 최대 영역의 집의 수를 구함
             * 5. K 크기의 영역의 집의 수가 0이면 K를 1 감소
             * 6. K가 0이 되면 반복문을 종료
             * 7. 최대 영역의 집의 수를 출력
             */
            while (maxAreaNum == 0) { // 최대 영역의 집의 수가 0이 아닐 때까지 반복
                for (int r = 1; r <= N + K + 1; r++) { // K 크기의 영역을 스캔
                    for (int c = 1; c <= N + K + 1; c++) {
                        areaNum = scan(r - K - 1, c - K - 1); // K 크기의 영역을 스캔

                        if (areaNum * M - cost[K] >= 0) { // K 크기의 영역의 집의 수가 0이 아니면 최대 영역의 집의 수를 구함
                            if (maxAreaNum < areaNum) maxAreaNum = areaNum; // 최대 영역의 집의 수를 구함
                        }
                    }
                }
                K--; // K를 1 감소, K가 0이 되면 반복문을 종료
            }

            bw.write("#" + t + " " + maxAreaNum + "\n");
        }

        bw.close();
        br.close();
    }
}