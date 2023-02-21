import java.io.*;
import java.util.StringTokenizer;

public class Main_5351 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            bw.write(((n * (n + 1)) / 2) + "\n");
        }
        bw.close();
    }
}
