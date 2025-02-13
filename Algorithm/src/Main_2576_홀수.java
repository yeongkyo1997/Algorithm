import java.io.*;
import java.util.StringTokenizer;

public class Main_2576_홀수 {
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
        if (sum == 0) bw.write(-1 + "\n");
        else bw.write(sum + "\n" + min + "\n");
        bw.close();
    }
}
