import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15649_N과_M_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visited;
    static int[] list = new int[9];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        solove(0, N, M);
        bw.close();
    }

    static void solove(int depth, int N, int M) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(list[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[depth] = i;
                solove(depth + 1, N, M);
                visited[i] = false;
            }
        }
    }
}
