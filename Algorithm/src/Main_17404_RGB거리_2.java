import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_17404_RGB거리_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[][] rgb;
    static int[][] dp;
    static int INF = 2147000000;
    static int result = INF;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        rgb = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.setAll(rgb[i], j -> Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[0], INF);
            dp[0][i] = rgb[0][i];

            IntStream.range(1, n).forEach(j -> {
                dp[j][0] = rgb[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2]);
                dp[j][1] = rgb[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2]);
                dp[j][2] = rgb[j][2] + Math.min(dp[j - 1][0], dp[j - 1][1]);
            });

            for (int j = 0; j < 3; j++) {
                if (i != j) result = Math.min(result, dp[n - 1][j]);
            }
        }
        bw.write(result + "\n");
        bw.close();
    }
}