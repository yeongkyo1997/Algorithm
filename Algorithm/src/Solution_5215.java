
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_5215 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N, L;
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            int[][] list = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                list[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            }
            int max = 0;

            for (int i = 0; i < (1 << N); i++) {
                int cal = 0;
                int score = 0;
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) == 0)
                        continue;
                    cal += list[i][0];
                    score += list[i][1];
                    if (cal <= L)
                        max = Math.max(score, max);
                    cal -= list[i][0];
                    score -= list[i][1];
                }
            }
            bw.write(max + "\n");
            bw.close();
        }
    }
}
