import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2294 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dp = new int[10001];
    static int[] list = new int[10001];
    private static int k;
    private static int result = Integer.MAX_VALUE;
    private static int n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list[i] = num;
            dp[num] = 1;
        }
        sol(0, 0, 0);
        if (result == Integer.MAX_VALUE)
            bw.write(-1 + "");
        else
            bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static void sol(int depth, int start, int sum) {
        if (sum == k) {
            result = Math.min(result, depth);
            return;
        }
        if (sum > k)
            return;
        for (int i = start; i < n; i++) {
            if (sum > k)
                return;
            sol(depth + 1, start, sum + list[i]);
        }
    }
}
