import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[100001];
        Arrays.fill(dp, -1001);

        st = new StringTokenizer(br.readLine());

        Arrays.setAll(arr, i -> Integer.parseInt(st.nextToken()));

        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
        }

        int result = -10001;
        for (int i : dp) result = Math.max(result, i);
        bw.write(String.valueOf(result));
        bw.close();
    }
}