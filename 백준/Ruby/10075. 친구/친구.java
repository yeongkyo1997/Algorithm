import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] trust, host, protocol;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        trust = new int[N];
        host = new int[N];
        protocol = new int[N];
        dp = new int[N][2];

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, N).forEach(i -> trust[i] = Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N; i++) {
            host[i] = Integer.parseInt(st.nextToken());
            protocol[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i][0] = trust[i];
        }

        for (int i = N - 1; i > 0; i--) {
            if (protocol[i] == 0) {
                dp[host[i]][0] += dp[i][1];
                dp[host[i]][1] += Math.max(dp[i][0], dp[i][1]);
            } else if (protocol[i] == 1) {
                dp[host[i]][0] = Math.max(dp[host[i]][0] + Math.max(dp[i][0], dp[i][1]), dp[host[i]][1] + dp[i][0]);
                dp[host[i]][1] += dp[i][1];
            } else {
                dp[host[i]][0] = Math.max(dp[host[i]][0] + dp[i][1], dp[host[i]][1] + dp[i][0]);
                dp[host[i]][1] += dp[i][1];
            }
        }

        bw.write(Math.max(dp[0][0], dp[0][1]) + "\n");
        bw.close();
    }
}