import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int origin = N;
        int result = 0;

        while (true) {
            int div = N / 10;
            int mod = N % 10;
            N = (mod * 10) + ((div + mod) % 10);
            result++;
            if (N == origin) {
                bw.write(result + "\n");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
