import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        IntStream.rangeClosed(1, n).forEach(i -> a[i] = Integer.parseInt(st.nextToken()));

        int[][] dp = new int[n + 1][4];
        int INF = (int) 1e9 + 1;
        dp[0][0] = 1;
        dp[0][1] = INF;
        dp[0][2] = INF;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = INF;

                if (j != 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                if (dp[i - 1][j] <= a[i]) dp[i][j] = Math.min(dp[i][j], a[i]);
                else {
                    if (dp[i - 1][j] <= a[i]) dp[i][j] = a[i];
                }
            }
        }

        int cur = IntStream.range(0, 4).filter(j -> dp[n][j] != INF).findFirst().orElse(4);

        if (cur == 4) bw.write("NO\n");
        else {
            bw.write("YES\n");
            bw.write(cur + "\n");

            for (int i = n; i > 0; i--) {
                if (dp[i][cur] != a[i]) {
                    bw.write(i + " " + dp[i][cur] + "\n");
                    cur -= 1;
                }
            }
        }

        bw.close();
    }
}