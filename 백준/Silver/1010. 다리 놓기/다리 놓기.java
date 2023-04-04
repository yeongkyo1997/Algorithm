import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 30; i++) {
            dp[i][i] = 1;
            dp[i][1] = i;
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            bw.write(solve(N, M) + "\n");
        }
        bw.close();
    }

    static int solve(int n, int m) {
        if (dp[m][n] != 0) return dp[m][n];
        return dp[m][n] = solve(n - 1, m - 1) + solve(n, m - 1);
    }
}