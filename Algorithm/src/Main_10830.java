import java.io.*;
import java.util.StringTokenizer;

public class Main_10830 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long[][] matrix = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) matrix[i][j] = Long.parseLong(st.nextToken());
        }

        long[][] result = pow(matrix, b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) bw.write(result[i][j] + " ");
            bw.write("\n");
        }
        bw.close();
    }

    public static long[][] pow(long[][] matrix, long b) {
        if (b == 1) return matrix;
        long[][] tmp = pow(matrix, b / 2);
        long[][] result = new long[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) result[i][j] += tmp[i][k] * tmp[k][j];
                result[i][j] %= MOD;
            }
        }

        if (b % 2 == 0) return result;
        else {
            long[][] res = new long[matrix.length][matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    for (int k = 0; k < matrix.length; k++)
                        res[i][j] += result[i][k] * matrix[k][j];
                    res[i][j] %= MOD;
                }
            }
            return res;
        }
    }
}
