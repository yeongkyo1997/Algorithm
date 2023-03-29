import java.io.*;
import java.util.StringTokenizer;

public class Main_1010_다리_놓기 {
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

    static int solve(int N, int M) {
        if (dp[M][N] != 0) return dp[M][N];
        return dp[M][N] = solve(N - 1, M - 1) + solve(N, M - 1);
    }
}
