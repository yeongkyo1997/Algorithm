import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T, N, M;
    static int[][] map = new int[25][25];
    static int[][][] area = new int[22][25 * 25][25 * 25];

    static int K;
    static int[] cost = new int[22];

    static void makeArea(int k) {
        cost[k] = k * k + (k - 1) * (k - 1);

        for (int r = 1; r <= k; r++) {
            for (int c = k + 1 - r; c <= k + r - 1; c++) {
                area[k][r][c] = 1;
            }
        }

        for (int r = k + 1; r <= 2 * k - 1; r++) {
            for (int c = r - k + 1; c <= 3 * k - r - 1; c++) {
                area[k][r][c] = 1;
            }
        }
    }

    static int scan(int sr, int sc) {
        int sum = 0;
        for (int r = 1; r <= 2 * K - 1; r++) {
            for (int c = 1; c <= 2 * K - 1; c++) {
                if (sr + r < 1 || sr + r > N || sc + c < 1 || sc + c > N) continue;
                sum += map[sr + r][sc + c] * area[K][r][c];
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 21; i++) makeArea(i);

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            K = N + 1;

            int areaNum, maxAreaNum;

            maxAreaNum = 0;
            while (maxAreaNum <= 0) {
                for (int r = 1; r <= N + K + 1; r++) {
                    for (int c = 1; c <= N + K + 1; c++) {
                        areaNum = scan(r - K - 1, c - K - 1);

                        if (areaNum * M - cost[K] >= 0) {
                            if (maxAreaNum < areaNum) maxAreaNum = areaNum;
                        }
                    }
                }

                K--;
            }

            bw.write("#" + tc + " " + maxAreaNum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}