import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long N;
    static long result = 1;

    public static void main(String[] args) throws Exception {
        N = Long.parseLong(br.readLine());

        for (long i = 2; i <= N / i; i++) {
            if (N % i == 0) {
                result *= i - 1;

                while (N % i == 0) {
                    result *= i;
                    N /= i;
                }
                result /= i;
            }
        }

        if (N != 1) result = result * (N - 1);

        bw.write(String.valueOf(result));
        bw.close();
    }
}