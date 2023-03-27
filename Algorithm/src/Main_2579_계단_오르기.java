import java.io.*;
import java.util.StringTokenizer;

public class Main_2579_계단_오르기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        try {
            dp[0] = 0;
            dp[1] = stair[1];
            dp[2] = stair[1] + stair[2];
        } catch (Exception e) {
            bw.write(stair[N] + "");
            bw.close();
            return;
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = stair[i] + Math.max(dp[i - 2], stair[i - 1] + dp[i - 3]);
        }
        bw.write(dp[N] + "\n");
        bw.close();
    }
}