import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_10826_피보나치_수_4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static BigInteger[] dp = new BigInteger[10001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
    }
}
