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

    static int[][] dp;
    static int[] cost;
    static int[] sum;
    static int t, k, i;

    static int dpf(int tx, int ty) {
        if (dp[tx][ty] != 1061109567) return dp[tx][ty];

        if (tx == ty) return dp[tx][ty] = 0;

        if (tx + 1 == ty) return dp[tx][ty] = cost[tx] + cost[ty];

        for (int mid = tx; mid < ty; ++mid) {
            int left = dpf(tx, mid);
            int right = dpf(mid + 1, ty);
            dp[tx][ty] = Math.min(dp[tx][ty], left + right);
        }

        return dp[tx][ty] += sum[ty] - sum[tx - 1];
    }

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            dp = new int[501][501];
            cost = new int[501];
            sum = new int[501];
            for (int i = 0; i < 501; i++) Arrays.fill(dp[i], 1061109567);
            k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (i = 1; i <= k; ++i) {
                cost[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + cost[i];
            }
            bw.write(dpf(1, k) + "\n");
        }
        bw.close();
    }
}