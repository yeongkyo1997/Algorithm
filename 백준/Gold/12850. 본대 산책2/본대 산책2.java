import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int D;
    static long[][] v = {{0, 1, 1, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 0, 0, 0, 0}, {1, 1, 0, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 1, 0, 0}, {0, 0, 1, 1, 0, 1, 0, 1}, {0, 0, 0, 1, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 0, 1, 0}};

    static long[][] multiply(long[][] M1, long[][] M2) {
        long[][] ret = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                long elem = 0;
                for (int k = 0; k < 8; k++) {
                    elem += (M1[i][k] * M2[k][j]);
                    elem %= 1000000007;
                }
                ret[i][j] = elem % 1000000007;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        D = Integer.parseInt(br.readLine());
        long[][] result = new long[8][8];

        for (int i = 0; i < 8; i++) {
            result[i][i] = 1;
        }
        long[][] factor = v;

        while (D > 0) {
            if ((D & 1) == 1) {
                result = multiply(result, factor);
                D -= 1;
            }
            factor = multiply(factor, factor);
            D /= 2;
        }
        bw.write(result[0][0] + "\n");
        bw.close();
    }
}