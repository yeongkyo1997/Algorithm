import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    private static final long mod = 1000000007;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        int R, G, B, K;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            long ANS = K;

            long tmp;
            tmp = powerModular(B, K) * powerModular(1 + B, mod - K - 1) % mod;
            tmp = (1 - tmp + mod) % mod;
            tmp = tmp * R % mod;

            ANS = (ANS + tmp) % mod;

            tmp = G * powerModular(B, mod - 2) % mod;
            tmp = tmp * K % mod;

            ANS = (ANS + tmp) % mod;
            bw.write(ANS + "\n");
        }
        bw.close();
    }

    public static long powerModular(long A, long power) {
        long result = 1;
        while (power > 0) {
            if (power % 2 == 1) {
                result = result * A % mod;
            }
            A = A * A % mod;
            power /= 2;
        }
        return result;
    }
}