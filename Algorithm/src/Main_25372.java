import java.io.*;
import java.util.StringTokenizer;

public class Main_25372 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        while (N-- != 0) {
            int len = br.readLine().length();
            bw.write(len >= 6 && len <= 9 ? "yes" + "\n" : "no" + "\n");
        }
        bw.close();
    }
}
