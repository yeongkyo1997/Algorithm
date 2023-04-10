import java.io.*;
import java.util.StringTokenizer;

import static java.util.Arrays.stream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        long[][] dp = new long[101][10];
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 9) dp[i][9] = dp[i - 1][8] % mod;
                else if (j == 0) dp[i][0] = dp[i - 1][1] % mod;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        long result = stream(dp[N], 0, 10).sum();

        bw.write(String.valueOf(result % mod));
        bw.close();
    }
}