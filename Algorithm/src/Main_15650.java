import java.io.*;
import java.util.StringTokenizer;

public class Main_15650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] list = new int[9];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        solove(0, N, M);
        bw.close();
    }

    static void solove(int depth, int N, int M) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) bw.write(list[i] + " ");
            bw.write("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (depth == 0 || list[depth - 1] < i) {
                list[depth] = i;
                solove(depth + 1, N, M);
            }
        }
    }
}
