import java.io.*;
import java.util.StringTokenizer;

public class Main_4134_다음_소수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static boolean isPrime(long num, long start, long end) {
        if (num <= 1) return false;
        for (long i = start; i * i <= end; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            for (long j = num; j < 4_000_000_001L; j++) {
                if (isPrime(num, num, 4_000_000_001L)) {
                    bw.write(j + "\n");
                    break;
                }
            }
        }
        bw.close();
    }
}
