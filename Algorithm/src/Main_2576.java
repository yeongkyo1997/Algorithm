import java.io.*;
import java.util.StringTokenizer;

public class Main_2576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int sum = 0;
        int min = 1000;
        for (int i = 0; i < 7; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N % 2 != 0) {
                sum += N;
                min = Math.min(N, min);
            }
        }

        bw.write(sum == 0 ? -1 + "\n" : sum + "\n" + min + "\n");
        bw.close();
    }
}
