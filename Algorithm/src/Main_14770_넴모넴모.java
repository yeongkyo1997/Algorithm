import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14770_넴모넴모 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static final int MOD = 1000000007;
    private static int[][] dp = new int[301][1 << 18];
    private static int n, m;

    public static int f(int idx, int bit) {
        if (idx == n * m) return 1;

        if (dp[idx][bit] != -1) return dp[idx][bit];

        dp[idx][bit] = f(idx + 1, bit >> 1) % MOD;

        if (idx % m == 0) {
            dp[idx][bit] += f(idx + 1, (bit >> 1) | (1 << m)) % MOD;
        } else {
            if ((bit & (1 << m)) == 0 || (bit & 2) == 0 || (bit & 1) == 0) {
                dp[idx][bit] += f(idx + 1, (bit >> 1) | (1 << m)) % MOD;
            }
        }

        return dp[idx][bit] % MOD;
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }

        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.write(f(0, 0) + "\n");
        bw.close();
    }
}
