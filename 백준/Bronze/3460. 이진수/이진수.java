import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder str = new StringBuilder(Integer.toBinaryString(n)).reverse();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') bw.write(i + " ");
            }
            bw.write("\n" + "");
        }
        bw.close();
    }
}