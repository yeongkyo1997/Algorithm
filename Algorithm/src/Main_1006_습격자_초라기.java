import java.util.Arrays;
import java.util.Scanner;

public class Main_1006_습격자_초라기 {
    static int[][] arr = new int[2][10001];
    static int[][] dp = new int[10001][3];
    static int n, w;

    static void solve() {
        for (int i = 2; i <= n; ++i) {
            int up = arr[0][i - 1] + arr[0][i] <= w ? 1 : 2;
            int down = arr[1][i - 1] + arr[1][i] <= w ? 1 : 2;
            int ver = arr[0][i] + arr[1][i] <= w ? 1 : 2;

            dp[i][0] = Math.min(Math.min(dp[i - 1][0] + ver, dp[i - 2][0] + up + down), Math.min(dp[i - 1][1] + up + 1, dp[i - 1][2] + 1 + down));
            dp[i][1] = Math.min(dp[i - 1][2] + down, dp[i - 1][0] + 1);
            dp[i][2] = Math.min(dp[i - 1][1] + up, dp[i - 1][0] + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            for (int i = 0; i < 10001; ++i) {
                Arrays.fill(dp[i], 0);
            }

            n = sc.nextInt();
            w = sc.nextInt();

            for (int i = 0; i < 2; ++i) {
                for (int j = 1; j <= n; ++j) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int t_up = arr[0][1];
            int t_down = arr[1][1];

            int ans = Integer.MAX_VALUE;
            dp[1][0] = arr[0][1] + arr[1][1] <= w ? 1 : 2;
            dp[1][1] =
                    dp[1][2] = 1;
            solve();
            ans = Math.min(ans, dp[n][0]);

            if (arr[0][1] + arr[0][n] <= w) {
                dp[1][0] = 2;
                dp[1][1] = dp[1][2] = 1;
                arr[0][1] = Integer.MAX_VALUE;
                solve();
                ans = Math.min(ans, dp[n][1]);
                arr[0][1] = t_up;
            }

            if (arr[1][1] + arr[1][n] <= w) {
                dp[1][0] = 2;
                dp[1][1] = dp[1][2] = 1;
                arr[1][1] = Integer.MAX_VALUE;
                solve();
                ans = Math.min(ans, dp[n][2]);
                arr[1][1] = t_down;
            }

            if (arr[0][1] + arr[0][n] <= w && arr[1][1] + arr[1][n] <= w) {
                arr[0][1] = arr[1][1] = Integer.MAX_VALUE;
                dp[1][0] = 2;
                dp[1][1] = dp[1][2] = 1;
                solve();
                ans = Math.min(ans, dp[n - 1][0]);
                arr[0][1] = t_up;
                arr[1][1] = t_down;
            }

            if (n == 1)
                ans = arr[0][1] + arr[1][1] <= w ? 1 : 2;

            System.out.println(ans);
        }
    }
}
