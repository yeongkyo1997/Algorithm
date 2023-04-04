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

    static long a, b;
    static long[] psum = new long[60];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        IntStream.range(1, 60).forEach(i -> psum[i] = (long) Math.pow(2, i - 1) + 2 * psum[i - 1]);

        bw.write(check(b) - check(a - 1) + "\n");
        bw.flush();
        bw.close();
    }

    static long check(long num) {
        long cnt = 0;
        String binaryString = Long.toBinaryString(num);
        int length = binaryString.length();

        for (int i = 0; i < length; i++) {
            if (binaryString.charAt(i) == '1') {
                int pow = length - i - 1;
                cnt += psum[pow];
                cnt += (num - Math.pow(2, pow) + 1);
                num = num - (int) Math.pow(2, pow);
            }
        }
        return cnt;
    }
}