import java.io.*;
import java.util.StringTokenizer;

public class Main_26574 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        while (N-- != 0) {
            int a = Integer.parseInt(br.readLine());
            bw.write(String.format("%d %d\n", a, a));
        }

        bw.close();
    }
}
