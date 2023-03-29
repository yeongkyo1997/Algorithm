import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11444_피보나치_수_6 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long mod = 1000000007;
    static long n;

    static long[][] multiple(long[][] a, long[][] b) {
        long[][] c = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
                c[i][j] %= mod;
            }
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        n = Long.parseLong(br.readLine());

        long[][] ans = {{1, 0}, {0, 1}};
        long[][] a = {{1, 1}, {1, 0}};

        while (n > 0) {
            if (n % 2 == 1) {
                ans = multiple(ans, a);
            }
            a = multiple(a, a);
            n /= 2;
        }

        bw.write(ans[0][1] + "\n");
        bw.close();
    }
}
