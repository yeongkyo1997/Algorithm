import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_23332_칩_만들기_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K;
    static int[][][] dp;
    static int[] a;

    static int dfs(int left, int right, int idx) {
        if (dp[left][right][idx] != -1) return dp[left][right][idx];
        if (idx == 0) return dp[left][right][idx] = 0;
        if (left > right) return dp[left][right][idx] = 0;

        dp[left][right][idx] = dfs(left + 1, right, idx);
        dp[left][right][idx] = Math.max(dp[left][right][idx], dfs(left + 1, right, idx - 1) + a[left]);

        for (int i = left + 1; i <= right; i++) {
            for (int x = 0; x <= idx - 1; x++) {
                dp[left][right][idx] = Math.max(dp[left][right][idx], a[left] * a[i] + dfs(left + 1, i - 1, x) + dfs(i + 1, right, idx - x - 1));
            }
        }
        return dp[left][right][idx];
    }

    static ArrayList<Integer> ans = new ArrayList<>();
    static ArrayList<Integer> ans2 = new ArrayList<>();

    static void reconstruct(int l, int r, int lft) {
        if (lft == 0 || l > r) return;

        if (dp[l][r][lft] == dp[l + 1][r][lft]) {
            reconstruct(l + 1, r, lft);
            return;
        }

        if (dp[l][r][lft] == dp[l + 1][r][lft - 1] + a[l]) {
            ans.set(l, l + 1);
            ans2.add(l + 1);
            reconstruct(l + 1, r, lft - 1);
            return;
        }

        for (int i = l + 1; i <= r; i++) {
            for (int x = 0; x <= lft - 1; x++) {
                if (dp[l][r][lft] == a[l] * a[i] + dp[l + 1][i - 1][x] + dp[i + 1][r][lft - x - 1]) {
                    ans.set(l, i + 1);
                    ans.set(i, l + 1);
                    ans2.add(l + 1);
                    reconstruct(l + 1, i - 1, x);
                    reconstruct(i + 1, r, lft - x - 1);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        a = new int[55];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
        dp = new int[55][55][22];

        for (int i = 0; i < 55; i++) {
            for (int j = 0; j < 55; j++) {
                for (int l = 0; l < 22; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }

        ans = new ArrayList<>();
        IntStream.range(0, N).forEach(i -> ans.add(0));

        dfs(0, N - 1, K);
        reconstruct(0, N - 1, K);
        while (ans2.size() < K) ans2.add(0);
        for (int x : ans2) bw.write(x + "\n");
        for (int x : ans) bw.write(x + "\n");
        bw.close();
    }
}