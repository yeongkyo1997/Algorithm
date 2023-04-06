import java.io.*;
import java.util.StringTokenizer;

public class Main_1149_RGB_거리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        int[][] list = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.arraycopy(list[0], 0, dp[0], 0, 3);

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + list[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + list[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + list[i][2];
        }

        int result = Integer.MAX_VALUE;
        for (int i : dp[N - 1]) {
            result = Math.min(i, result);
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}