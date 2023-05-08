import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2833_나이트 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, t, sx, sy;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        dp = new int[n][t + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                for (int l = k; l <= t; l += k) {
                    dp[i][l] |= (1 << j);
                }
            }
        }
        dp[sx - 1][0] |= (1 << (sy - 1));

        for (int l = 1; l <= t; l++) {
            for (int i = 0; i < n; i++) {
                int v = 0;
                if (i - 2 >= 0) v |= (dp[i - 2][l - 1] >> 1) | (dp[i - 2][l - 1] << 1);
                if (i + 2 < n) v |= (dp[i + 2][l - 1] << 1) | (dp[i + 2][l - 1] >> 1);
                if (i > 0) v |= (dp[i - 1][l - 1] >> 2) | (dp[i - 1][l - 1] << 2);
                if (i + 1 < n) v |= (dp[i + 1][l - 1] >> 2) | (dp[i + 1][l - 1] << 2);
                dp[i][l] &= v;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((dp[i][t] >> j & 1) == 1) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((dp[i][t] >> j & 1) == 1) {
                    bw.write((i + 1) + " " + (j + 1) + "\n");
                }
            }
        }
        bw.close();
    }
}
