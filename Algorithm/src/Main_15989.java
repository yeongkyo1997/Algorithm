import java.io.*;
import java.util.StringTokenizer;

public class Main_15989 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int result = 0;
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        dp[0] = 1;
        for (int i = 1; i <= 3; i++) {
            for (int j = i; j <= 10000; j++) dp[j] += dp[j - i];
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
