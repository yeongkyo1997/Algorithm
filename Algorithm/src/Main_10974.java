import java.io.*;
import java.util.StringTokenizer;

public class Main_10974 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] visited = new int[9];
    static int[] list = new int[9];
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        solve(0);
        bw.flush();
        bw.close();
    }

    static void solve(int depth) throws IOException {
        if (depth == N) {
            for (int i = 0; i < N; i++) bw.write(list[i] + " ");
            bw.write("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                list[depth] = i;
                solve(depth + 1);
                visited[i] = 0;
            }
        }
    }
}
