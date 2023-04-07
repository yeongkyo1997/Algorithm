import java.io.*;
import java.util.StringTokenizer;

public class Main_2156_포도주_시식 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        int[] dp = new int[10001];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0], arr[1]) + arr[2];
        dp[2] = Math.max(dp[1], dp[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        bw.write(String.valueOf(dp[n - 1]));
        bw.close();
    }
}
