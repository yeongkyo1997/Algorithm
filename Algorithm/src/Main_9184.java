import java.io.*;
import java.util.StringTokenizer;

public class Main_9184 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && a == b && a == c) break;
            bw.write(String.format("w(%d, %d, %d) = %d", a, b, c, func(a, b, c)));
        }
        bw.close();
    }

    static int func(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a > 20 || b > 20 || c > 20) return func(20, 20, 20);

        if (a < b && b < c) return func(a, b, c - 1) + func(a, b - 1, c - 1) - func(a, b - 1, c);

        return func(a - 1, b, c) + func(a - 1, b - 1, c) + func(a - 1, b, c - 1) - func(a - 1, b - 1, c - 1);
    }
}
