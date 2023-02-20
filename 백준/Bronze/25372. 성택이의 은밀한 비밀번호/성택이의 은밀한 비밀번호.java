import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        while (N-- != 0) {
            int len = br.readLine().length();
            if (len >= 6 && len <= 9) bw.write("yes" + "\n");
            else bw.write("no" + "\n");
        }
        bw.close();
    }
}