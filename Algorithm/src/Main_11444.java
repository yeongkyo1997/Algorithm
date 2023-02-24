import java.io.*;
import java.util.StringTokenizer;

// 나무위키 참고 https://namu.wiki/w/%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98%20%EC%88%98%EC%97%B4
public class Main_11444 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int MOD;

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        long[][] matrix = {{1, 1}, {1, 0}};
        long[][] result = fibo(matrix, n);
        bw.write(result[0][1] + "");
        bw.close();
    }

    public static long[][] fibo(long[][] matrix, long b) {
        if (b == 1) return matrix;
        long[][] tmp = fibo(matrix, b / 2);
        long[][] result = new long[matrix.length][matrix.length];

        MOD = 1000000007;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    result[i][j] += tmp[i][k] * tmp[k][j];
                }
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
