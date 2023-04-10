import java.io.*;
import java.util.StringTokenizer;

public class Main_4134_다음_소수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static boolean isPrime(long n) {
        if (n < 2) return false;

        for (long i = 2; i * i < n + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine());

            while (true) {
                if (isPrime(n)) {
                    bw.write(n + "\n");
                    bw.flush();
                    break;
                }
                n++;
            }
        }
        bw.close();
    }
}