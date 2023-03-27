import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n, k;
        int[] dp;
        int[] list;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k + 1];
        list = new int[n + 1];

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) list[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = list[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - list[i]] + 1);
            }
        }

        bw.write(dp[k] == 10001 ? "-1" : dp[k] + "");
        bw.flush();
        bw.close();
    }
}
