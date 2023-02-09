package N_M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_8 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] inputs, numbers;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        inputs = new int[N];
        numbers = new int[M];
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs);
        solve(0, 0);
        bw.flush();
        bw.close();
    }

    static void solve(int depth, int start) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(numbers[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[depth] = inputs[i];
            solve(depth + 1, i);
        }
    }
}
