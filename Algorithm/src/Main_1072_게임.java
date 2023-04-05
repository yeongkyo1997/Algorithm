import java.io.*;
import java.util.StringTokenizer;

public class Main_1072_게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        long x, y, z;
        st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        z = 100 * y / x;


        long left = 0;
        long right = x;
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            long res = 100 * (y + mid) / (x + mid);

            if (res > z) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (right == x) bw.write("-1");
        else bw.write(String.valueOf(right));
        bw.close();
    }
}
