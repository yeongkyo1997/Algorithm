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
        int T = Integer.parseInt(br.readLine());

        int A, B, C;
        A = B = C = 0;
        block: {
            if (T % 10 != 0) {
                bw.write(-1 + "\n");
                break block;
            }

            A = T / 3600;
            T %= 3600;
            B = T / 60;
            T %= 60;
            C = T / 10;

            bw.write(A + " " + B + " " + C + "\n");
        }
        bw.flush();
        bw.close();
    }
}
