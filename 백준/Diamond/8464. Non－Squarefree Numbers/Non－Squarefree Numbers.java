import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[] arr = new int[1234567];
    static int MIL = 1000000;

    static void setup() {
        arr[1] = 1;
        for (int i = 1; i <= MIL; i++) {
            for (int j = 2 * i; j <= MIL; j += i) {
                arr[j] -= arr[i];
            }
        }
    }


    static long f(long k) {
        long ans = 0;
        for (long i = 1; i * i <= k; i++) ans += arr[(int) i] * k / (i * i);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        setup();
        long k = Long.parseLong(br.readLine());
        long s = 0, e = 100000000000L;
        while (s < e - 1) {
            long mid = (s + e) / 2;
            if (mid - f(mid) < k) s = mid;
            else e = mid;
        }
        bw.write(e + "");
        bw.flush();
    }
}