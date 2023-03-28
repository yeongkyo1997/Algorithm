import java.io.*;
import java.util.StringTokenizer;

public class Main_9465_스티커 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N + 1][2];
            int[][] dp = new int[N + 1][2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            dp[1][0] = map[1][0];
            dp[1][1] = map[1][1];
            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + map[i][0];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + map[i][1];
            }
            bw.write(Math.max(dp[N][0], dp[N][1]) + "\n");
        }
        bw.close();
    }
}
