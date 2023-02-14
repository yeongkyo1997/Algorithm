import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        bw.write(reverse(reverse(x) + reverse(y)) + "");
        bw.close();
    }

    static int reverse(int num) {
        int result = 0;

        while (num != 0) {
            result += num % 10;
            num /= 10;
            result *= 10;
        }
        return result / 10;
    }
}
