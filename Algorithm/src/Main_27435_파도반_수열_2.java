import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_27435_파도반_수열_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long[][] arr = new long[3][3];
    static long[][] result = new long[3][3];
    static long N;
    static long[] sts = {0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16, 21, 28, 37, 49, 65, 86, 114, 151, 200, 265, 351, 465, 616, 816, 1081, 1432, 1897, 2513, 3329, 4410, 5842, 7739, 10252, 13581, 17991, 23833, 31572, 41824, 55405, 73396, 97229, 128801, 170625, 226030, 299426, 396655, 525456, 696081, 922111, 1221537, 1618192, 2143648, 2839729};

    static void multi(long[][] A, long[][] B) {
        long[][] tmp = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int t = 0; t < 3; t++) {
                    tmp[i][j] += (A[i][t] * B[t][j]) % 998244353;
                    tmp[i][j] += 998244353;
                    tmp[i][j] %= 998244353;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = tmp[i][j] % 998244353;
            }
        }
    }

    static void divide(long B) {
        if (B == 0) return;
        if (B % 2 == 1) multi(result, arr);
        multi(arr, arr);
        divide(B / 2);
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = 0;
                    result[i][j] = 0;
                }
            }

            arr[0][1] = 1;
            arr[0][2] = 1;
            result[0][1] = 1;
            result[0][2] = 1;

            for (int i = 0; i < 3; i++) {
                if (i > 0) {
                    arr[i][i - 1] = 1;
                    result[i][i - 1] = 1;
                }
            }

            N = Long.parseLong(br.readLine());
            if (N <= 55) bw.write(sts[(int) N] + "\n");
            else {
                divide(N);
                bw.write(result[0][0] + "\n");
            }
        }

        bw.close();
    }
}