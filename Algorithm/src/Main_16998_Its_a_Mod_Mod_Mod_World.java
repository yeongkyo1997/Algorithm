import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16998_Its_a_Mod_Mod_Mod_World {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long divSum(long p, long q, long n) {
        return n == 0 || p == 0 ? 0 : q == 1 ? p * n * (n + 1) / 2 : p > q ? divSum(p % q, q, n) + n * (n + 1) / 2 * (p / q) : n * (n * p / q) + (n / q) - divSum(q, p, n * p / q);
    }

    static long modSum(long p, long q, long n) {
        long gcd = gcd(p, q);
        return p * n * (n + 1) / 2 - q * divSum(p / gcd, q / gcd, n);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken());
            long q = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            bw.write(modSum(p, q, n) + "\n");
        }
        bw.close();
    }
}