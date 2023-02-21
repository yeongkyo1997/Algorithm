import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (list[i] > list[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }


        bw.write(dp[N - 1] + "");
        bw.close();
    }
}
