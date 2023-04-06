import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_10075_친구 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] confi, host, proto;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        confi = new int[N];
        host = new int[N];
        proto = new int[N];
        dp = new int[N][2];

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, N).forEach(i -> confi[i] = Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        IntStream.range(1, N).forEach(i -> {
            host[i] = Integer.parseInt(st.nextToken());
            proto[i] = Integer.parseInt(st.nextToken());
        });

        bw.write(find() + "\n");
        bw.close();
    }

    static int find() {
        IntStream.range(0, N).forEach(i -> dp[i][0] = confi[i]);

        for (int i = N - 1; i > 0; i--) {
            if (proto[i] == 0) {
                dp[host[i]][0] += dp[i][1];
                dp[host[i]][1] += Math.max(dp[i][0], dp[i][1]);
            } else if (proto[i] == 1) {
                dp[host[i]][0] = Math.max(dp[host[i]][0] + Math.max(dp[i][0], dp[i][1]), dp[host[i]][1] + dp[i][0]);
                dp[host[i]][1] += dp[i][1];
            } else {
                dp[host[i]][0] = Math.max(dp[host[i]][0] + dp[i][1], dp[host[i]][1] + dp[i][0]);
                dp[host[i]][1] += dp[i][1];
            }
        }

        return Math.max(dp[0][0], dp[0][1]);
    }
}