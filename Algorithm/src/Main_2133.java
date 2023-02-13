import java.io.*;
import java.util.StringTokenizer;

public class Main_2133 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n, dp[] = new int[31];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        n = Integer.parseInt(br.readLine());

        for (int i = 4; i < n + 1; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 4; j < i + 1; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }
        bw.write(dp[n] + "");
        bw.close();
    }

}
