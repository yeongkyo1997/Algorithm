package N_M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_7 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static int m;
    static int[] numbers;
    static int[] inputs;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[m];
        inputs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);
        solve(0);
        bw.flush();
        bw.close();
    }

    static void solve(int depth) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(numbers[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            numbers[depth] = inputs[i];
            solve(depth + 1);
        }
    }
}
