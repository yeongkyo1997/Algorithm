import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15988 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dp = new int[1000001];
    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        bw.write(solve(n) + "\n");
        bw.flush();
        bw.close();
    }

    static int solve(int num) {
        if (num == 0) {
            dp[0] = 0;
            return 0;
        }
        if (dp[num] == 0) {
            dp[num - 1] = solve(num - 1);
            dp[num - 2] = solve(num - 2);
            dp[num - 3] = solve(num - 3);
        }
        dp[num] = dp[num - 1] + dp[num - 2] + dp[num - 3];
        return dp[num];
    }
}
