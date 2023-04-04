//INF = 2147000000
//        n = int(input())
//        rgb = []
//        ans = INF
//        for _ in range(n):
//        rgb.append(list(map(int, input().split())))
//
//        for i in range(3):
//        dp = [[INF, INF, INF] for _ in range(n)]
//        dp[0][i] = rgb[0][i]
//        for j in range(1, n):
//        dp[j][0] = rgb[j][0] + min(dp[j-1][1], dp[j-1][2])
//        dp[j][1] = rgb[j][1] + min(dp[j-1][0], dp[j-1][2])
//        dp[j][2] = rgb[j][2] + min(dp[j-1][0], dp[j-1][1])
//
//        for j in range(3):
//        if i != j:
//        ans = min(ans, dp[-1][j])
//        print(ans)

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//py3 to java
public class Main_17404_RGB거리_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[][] rgb;
    static int[][] dp;
    static int INF = 2147000000;
    static int result = INF;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        rgb = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[0], INF);
            dp[0][i] = rgb[0][i];

            for (int j = 1; j < n; j++) {
                dp[j][0] = rgb[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2]);
                dp[j][1] = rgb[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2]);
                dp[j][2] = rgb[j][2] + Math.min(dp[j - 1][0], dp[j - 1][1]);
            }

            for (int j = 0; j < 3; j++) {
                if (i != j) result = Math.min(result, dp[n - 1][j]);
            }
        }
        bw.write(result + "\n");
        bw.close();
    }
}