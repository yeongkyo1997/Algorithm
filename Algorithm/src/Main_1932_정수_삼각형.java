import java.io.*;
import java.util.StringTokenizer;

public class Main_1932_정수_삼각형 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 2];
        int[][] list = new int[N + 1][N + 2];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i + 1; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = list[1][1];

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j + 1]) + list[i][j];
            }
        }
        int result = 0;
        for (int i : dp[N]) {
            result = Math.max(result, i);
        }
        bw.write(result + "");
        bw.close();
    }
}
