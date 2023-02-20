import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            ArrayList<int[]> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());

                list.add(new int[]{score, cal});
            }

            int max = 0;
            for (int i = 1; i < (1 << N); i++) {
                int score = 0;
                int cal = 0;
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) != 0) {
                        score += list.get(j)[0];
                        cal += list.get(j)[1];
                    }
                }

                if (cal <= L) {
                    max = Math.max(max, score);
                }
            }

            bw.write("#" + (t + 1) + " " + max + "\n");
        }
        bw.flush();
        bw.close();

    }
}