import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1328_고층_빌딩 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        bw.write(solve(n, l, r) + "\n");
        bw.close();
    }

    static int solve(int n, int l, int r) {
        if (dp[n][l][r] != 0) return dp[n][l][r];
        if (n == 1) {
            if (l == 1 && r == 1) return 1;
            else return 0;
        }
        if (l == 1 && r == 1) return 0;
        if (l == 1) return dp[n][l][r] = (solve(n - 1, l, r - 1) + solve(n - 1, l, r) * (n - 2)) % 1000000007;
        if (r == 1) return dp[n][l][r] = (solve(n - 1, l - 1, r) + solve(n - 1, l, r) * (n - 2)) % 1000000007;
        return dp[n][l][r] = (solve(n - 1, l - 1, r) + solve(n - 1, l, r - 1) + solve(n - 1, l, r) * (n - 2)) % 1000000007;
    }
}