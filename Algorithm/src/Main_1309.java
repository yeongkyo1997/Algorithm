import java.io.*;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.rangeClosed;

public class Main_1309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        final int MOD = 9901;
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        rangeClosed(2, N).forEach(i -> {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        });

        bw.write((dp[N][0] + dp[N][1] + dp[N][2]) % MOD + "");
        bw.close();
    }
}
