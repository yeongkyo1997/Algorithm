import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1023_괄호_문자열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static long K;
    static long[][][] dp = new long[53][103][2];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        for (int i = 0; i < 53; i++) {
            for (int j = 0; j < 103; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        long ans = go(0, 0, 0);

        if (ans < K) bw.write("-1");
        else go2(0, 0, 0, K);


        bw.close();
    }

    static long go(int pos, int cnt, int wrong) {
        if (pos == N) {
            int tmp;
            if (wrong * cnt <= 0) tmp = 1;
            else tmp = 0;
            return tmp;
        }

        if (dp[pos][cnt + N][wrong] != -1) {
            return dp[pos][cnt + N][wrong];
        }

        dp[pos][cnt + N][wrong] = 0;

        dp[pos][cnt + N][wrong] += go(pos + 1, cnt + 1, wrong);
        int tmp;
        if (wrong * cnt <= 0) tmp = 1;
        else tmp = 0;
        dp[pos][cnt + N][wrong] += go(pos + 1, cnt - 1, tmp);

        return dp[pos][cnt + N][wrong];
    }

    static void go2(int pos, int cnt, int wrong, long k) throws Exception {
        if (pos == N) {
            return;
        }

        if (go(pos + 1, cnt + 1, wrong) >= k) {
            bw.write("(");
            go2(pos + 1, cnt + 1, wrong, k);
        } else {
            bw.write(")");
            int tmp;
            if (wrong * cnt <= 0) tmp = 1;
            else tmp = 0;
            go2(pos + 1, cnt - 1, tmp, k - go(pos + 1, cnt + 1, wrong));
        }
    }
}