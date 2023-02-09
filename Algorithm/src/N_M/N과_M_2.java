package N_M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N과_M_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] numbers;

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];
        solve(0, 1);
        bw.flush();
        bw.close();
    }

    static void solve(int def, int start) throws IOException {
        if (def == M) {
            for (int j = 0; j < M; j++) {
                bw.write(numbers[j] + " ");
            }
            bw.write("\n" + "");
            return;
        }
        for (int i = start; i <= N; i++) {
            numbers[def] = i;
            solve(def + 1, i + 1);
        }
    }
}
