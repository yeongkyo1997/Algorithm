package N_M;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N과_M_4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        dfs(0, N, M, arr);
        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int N, int M, int[] arr) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (depth == 0 || arr[depth - 1] <= i) {
                arr[depth] = i;
                dfs(depth + 1, N, M, arr);
            }
        }
    }
}