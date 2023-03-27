import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_10826 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static BigInteger[] dp = new BigInteger[10001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        IntStream.range(2, n + 1).forEach(i -> dp[i] = dp[i - 1].add(dp[i - 2]));
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
    }
}
