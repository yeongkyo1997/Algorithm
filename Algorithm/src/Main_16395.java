import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16395 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] dp;

    static int combi(int n, int k) {
        if (k == 0 || n == k) {
            dp[n][k] = 1;
            return dp[n][k];
        }

        if (dp[n - 1][k - 1] == 0)
            dp[n - 1][k - 1] = combi(n - 1, k - 1);
        if (dp[n - 1][k] == 0)
            dp[n - 1][k] = combi(n - 1, k);
        dp[n][k] = dp[n - 1][k] + dp[n - 1][k - 1];
        return dp[n][k];
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];

        bw.write(combi(n, k) + "\n");
        bw.flush();
        bw.close();
    }
}
