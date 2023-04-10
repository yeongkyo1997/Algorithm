import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_2193_이친수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[100];
        dp[0] = 0;
        dp[1] = 1;

        IntStream.range(2, N + 1).forEach(i -> dp[i] = dp[i - 1] + dp[i - 2]);

        bw.write(String.valueOf(dp[N]));
        bw.close();
    }
}
