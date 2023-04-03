import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m, r, s;
    static int[][] a = new int[20][20];
    static int[][] b = new int[20][20];
    static int[][] cst = new int[20][20];
    static int[][] dp = new int[20][20];

    static int solve(int bit) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] = 0;
            }
        }
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                b[start][j] += a[i][j];
            }
            if (((bit >> i) & 1) == 1) start++;
        }
        for (int i = 0; i <= start; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] += b[i][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int ret = 0;
                for (int k = 0; k <= start; k++) {
                    ret = Math.max(ret, b[k][j] - b[k][i - 1]);
                }
                cst[i][j] = ret;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i][j] = cst[1][i];
                if (j != 0) {
                    for (int k = 0; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], cst[k + 1][i]));
                    }
                }
            }
        }
        return dp[m][s];
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ret = 1000000000;
        for (int i = 0; i < (1 << (n - 1)); i++) {
            int c = 0;
            for (int j = 0; j < n - 1; j++) {
                if (((i >> j) & 1) == 1) c++;
            }
            if (c == r) {
                ret = Math.min(ret, solve(i));
            }
        }
        bw.write(ret + "\n");
        bw.close();
    }
}