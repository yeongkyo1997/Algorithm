import java.io.*;
import java.util.StringTokenizer;

public class Main_2839 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N != 0) {
            if (N % 5 == 0) {
                cnt += N / 5;
                N = 0;
            } else {
                N -= 3;
                cnt++;
            }

        }
        bw.write(cnt == 0 ? -1 + "" : cnt + "\n");
        bw.close();
    }
}
