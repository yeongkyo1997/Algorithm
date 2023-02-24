import java.io.*;
import java.util.StringTokenizer;

public class Main_26099 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        long N = Long.parseLong(br.readLine());
        long cnt = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                cnt += N / 5;
                N = 0;
                break;
            } else {
                N -= 3;
                cnt++;
            }
        }

        bw.write((N == 0 ? cnt : -1) + "");
        bw.close();
    }
}
