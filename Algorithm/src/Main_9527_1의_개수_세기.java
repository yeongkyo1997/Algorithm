import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_9527_1의_개수_세기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long[] pow = new long[55];
    static long A, B;

    static long getOne(long x) {
        long ret = x & 1;

        for (int i = 54; i > 0; i--) {
            if ((x & (1L << i)) != 0) {
                ret += pow[i - 1] + (x - (1L << i) + 1);
                x -= 1L << i;
            }
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        pow[0] = 1;
        IntStream.range(1, 55).forEach(i -> pow[i] = 2 * pow[i - 1] + (1L << i));

        bw.write(String.valueOf(getOne(B) - getOne(A - 1)));
        bw.close();
    }
}

