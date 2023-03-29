import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][] dp;
    static int N;


    static void triangle() throws Exception {
        int i, j;
        int max = Integer.MIN_VALUE;
        for (i = 1; i <= N; i++) {
            for (j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] += dp[i - 1][j];
                } else if (i == j) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + dp[i][j];
                }
                if (max < dp[i][j]) max = dp[i][j];
            }
        }
        bw.write(max + "\n");
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        triangle();
        bw.close();
    }
}