import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1081 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        long a, b;
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        bw.write(sum(b) - sum(a - 1) + "");
        bw.close();
    }

    static long sum(long n) {
        long[] list = new long[10];
        long s = 1, t, r;

        while (n > 0) {
            t = n / (s * 10);
            r = n % (s * 10);

            for (int i = 0; i < 10; i++)
                list[i] += t * s;
            for (int i = 1; i < r / s + 1; i++) list[i] += s;
            list[(int) ((r / s + 1) % 10)] += r % s;
            n -= 9 * s;
            s *= 10;
        }
        return IntStream.range(1, 10).mapToLong(i -> i * list[i]).sum();
    }
}
