import java.io.*;
import java.util.StringTokenizer;

public class Main_24893 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static long a;
    private static long b;
    private static long E;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Long.parseLong(br.readLine());
        b = Long.parseLong(br.readLine());
        E = Long.parseLong(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long[] dp = new long[N];
        dp[0] = a * arr[0] * arr[0] + b;
        for (int i = 1; i < N; i++) {
            dp[i] = a * arr[i] * arr[i] + b;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + E + a * (arr[i] - arr[j]) * (arr[i] - arr[j]) + b);
            }
        }

        bw.write(dp[N - 1] + "");
        bw.close();
    }
}
