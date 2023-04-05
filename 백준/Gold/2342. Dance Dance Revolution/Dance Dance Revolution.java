import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int INF = 1000000000;
    static int[][][] dp = new int[100001][5][5];
    static int[] l = new int[100001];
    static int n;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = 0;

        while (st.hasMoreTokens()) {
            l[n++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        dp[0][0][0] = 0;

        for (int i = 1; i < n; i++) {
            int move = l[i - 1];

            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    dp[i][move][right] = Math.min(dp[i][move][right], dp[i - 1][left][right] + getDistance(left, move));
                    dp[i][left][move] = Math.min(dp[i][left][move], dp[i - 1][left][right] + getDistance(right, move));
                }
            }
        }
        int result = INF;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result = Math.min(result, dp[n - 1][i][j]);
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }

    static int getDistance(int curr, int target) {
        if (curr == target) return 1;
        else if (curr == 0) return 2;
        else if (Math.abs(curr - target) % 2 == 0) return 4;
        else return 3;
    }
}