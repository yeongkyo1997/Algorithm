import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1644_소수의_연속합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static boolean[] prime = new boolean[4000001];
    static int[] primes = new int[4000001];
    static int cnt = 0;

    static void gogo() {
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                primes[cnt++] = i;
                for (int j = i + i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        gogo();
        int result = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < cnt; i++) {
            sum += primes[i];
            while (sum > n) {
                sum -= primes[start++];
            }
            if (sum == n) result++;
        }
        System.out.println(result);
    }
}