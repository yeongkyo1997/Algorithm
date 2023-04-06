import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long N, K, A, B, mid;
    static long mod = 1000000007;

    static long solve(int x) {
        if (x == 0) return 1;

        if (x % 2 == 1) return B * solve(x - 1) % mod;
        else {
            mid = solve(x / 2);
            return mid * mid % mod;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        A = 1;

        for (int i = (int) N; i >= N - K + 1; i--) A = (A * i) % mod;

        B = 1;
        for (int i = 1; i <= K; i++) B = (B * i) % mod;

        B = solve((int) (mod - 2));

        bw.write(String.valueOf(A * B % mod));

        bw.close();
    }
}