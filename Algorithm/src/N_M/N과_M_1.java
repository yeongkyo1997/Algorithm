package N_M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N과_M_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static boolean[] visited;
    static int[] numbers, inputs;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

    }

    static void solve(int cnt) throws IOException {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                bw.write(numbers[i] + " ");
            }
            bw.write("\n" + "");
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
        }
    }
}
