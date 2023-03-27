import java.io.*;
import java.util.StringTokenizer;

public class Main_16926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] list = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) list[i][j] = Integer.parseInt(st.nextToken());
        }

        int min = Math.min(N, M) / 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < min; j++) {
                int temp = list[j][j];

                for (int k = j; k < M - j - 1; k++) list[j][k] = list[j][k + 1];

                for (int k = j; k < N - j - 1; k++) list[k][M - j - 1] = list[k + 1][M - j - 1];

                for (int k = M - j - 1; k > j; k--) list[N - j - 1][k] = list[N - j - 1][k - 1];

                for (int k = N - j - 1; k > j; k--) list[k][j] = list[k - 1][j];
                list[j + 1][j] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) bw.write(list[i][j] + " ");
            bw.write("\n");
        }
        bw.close();
    }
}
