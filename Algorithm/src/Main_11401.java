import java.io.*;
import java.util.StringTokenizer;

public class Main_11401 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long[][] dp;
    static final int MOD = 1000000007;

    static long combi(int n, int k) {
        if (k == 0 || n == k) {
            dp[k][0] = dp[k][k] = 1;
            return 1;
        }

        if (dp[n - 1][k - 1] == 0) dp[n - 1][k - 1] = combi(n - 1, k - 1) % MOD;
        if (dp[n - 1][k] == 0) dp[n - 1][k] = combi(n - 1, k) % MOD;
        return dp[n - 1][k - 1] + dp[n - 1][k];
    }

    public static void main(String[] args) throws IOException {
        int n, k;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new long[n + 1][k + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (dp[i][j] != 0) continue;
                if (j == 0 || i == k) {
                    dp[i][0] = dp[j][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        bw.write(dp[n][k] + "\n");
        bw.flush();
        bw.close();
    }
}
