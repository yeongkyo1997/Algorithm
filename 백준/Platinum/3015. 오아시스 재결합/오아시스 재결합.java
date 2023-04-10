import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, A;
    static long result = 0;
    static int[][] dp = new int[500000][2];
    static int vIdx = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        A = Integer.parseInt(br.readLine());
        dp[vIdx][0] = A;
        dp[vIdx][1] = 1;
        vIdx++;

        for (int i = 1; i < N; ++i) {
            A = Integer.parseInt(br.readLine());

            int idx = -1;

            for (int j = vIdx - 1; j >= 0; --j) {
                if (dp[j][0] < A) {
                    result += dp[j][1];
                    vIdx--;
                } else if (dp[j][0] == A) {
                    result += dp[j][1];
                    idx = j;
                } else {
                    result++;
                    break;
                }
            }

            if (idx == -1) {
                dp[vIdx][0] = A;
                dp[vIdx][1] = 1;
                vIdx++;
            } else dp[idx][1]++;
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}