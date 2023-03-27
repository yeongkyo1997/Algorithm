import java.io.*;
import java.util.StringTokenizer;

public class Main_24893 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long a = Long.parseLong(br.readLine());
        long b = Long.parseLong(br.readLine());
        long e = Long.parseLong(br.readLine());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long[] dp = new long[n];
        dp[0] = a * arr[0] * arr[0] + b;
        for (int i = 1; i < n; i++) {
            dp[i] = a * arr[i] * arr[i] + b;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + e + a * (arr[i] - arr[j]) * (arr[i] - arr[j]) + b);
            }
        }

        bw.write(dp[n - 1] + "");
        bw.close();
    }
}
