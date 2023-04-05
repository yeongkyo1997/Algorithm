import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] A, C;
    static int[][] dp;
    static int result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        C = new int[N + 1];
        dp = new int[N + 1][10001];
        result = 10001;

        st = new StringTokenizer(br.readLine());
        IntStream.rangeClosed(1, N).forEach(i -> A[i] = Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        IntStream.rangeClosed(1, N).forEach(i -> C[i] = Integer.parseInt(st.nextToken()));


        for (int i = 1; i <= N; i++) {
            int byte_ = A[i];
            int cost = C[i];

            for (int j = 1; j <= 10000; j++) {
                if (j < cost) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(byte_ + dp[i - 1][j - cost], dp[i - 1][j]);
                if (dp[i][j] >= M) result = Math.min(result, j);
            }
        }

        if (M != 0) bw.write(String.valueOf(result));
        else bw.write("0");

        bw.close();
    }
}