import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_12920_평범한_배낭_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[] dp;
    static List<Integer> weight = new ArrayList<>();
    static List<Integer> sati = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int idx = 1;
            while (K > 0) {
                int tmp = Math.min(idx, K);

                weight.add(V * tmp);
                sati.add(C * tmp);

                idx *= 2;
                K -= tmp;
            }
        }

        for (int i = 0; i < weight.size(); i++) {
            for (int j = M; j > 0; j--) {
                if (j >= weight.get(i)) {
                    dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + sati.get(i));
                }
            }
        }

        bw.write(dp[M] + "");
        bw.close();
    }
}