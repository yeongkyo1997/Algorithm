import java.io.*;
import java.util.StringTokenizer;

public class Main_11402 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());

        bw.write(lucas(N, K, P) + "");
        bw.close();
    }

    // 뤼카 정리
    static long lucas(long n, long m, long p) {
        if (m == 0) return 1;
        long n1 = n % p;
        long m1 = m % p;
        if (n1 < m1) return 0;
        return (lucas(n / p, m / p, p) * nCr(n1, m1, p)) % p;
    }

    // nCr
    static long nCr(long n, long r, long p) {
        if (r == 0) return 1;
        long[] fac = new long[(int) p];
        fac[0] = 1;
        for (int i = 1; i < p; i++) {
            fac[i] = fac[i - 1] * i % p;
        }
        return (fac[(int) n] * pow(fac[(int) r], p - 2, p) % p * pow(fac[(int) (n - r)], p - 2, p) % p) % p;
    }

    // 거듭제곱
    static long pow(long a, long b, long p) {
        if (b == 0) return 1;
        if (b % 2 == 0) {
            long half = pow(a, b / 2, p);
            return half * half % p;
        } else {
            return a * pow(a, b - 1, p) % p;
        }
    }
}
