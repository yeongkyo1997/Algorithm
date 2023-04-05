import java.io.*;
import java.util.StringTokenizer;

public class Main_10990_별_찍기_15 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            bw.write(" " + "");
        }

        bw.write("*" + "\n");
        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < N - i; j++) {
                bw.write(" " + "");
            }
            bw.write("*" + "");
            for (int j = 0; j < 2 * i - 3; j++) {
                bw.write(" " + "");
            }
            bw.write("*" + "\n");

        }
        bw.close();
    }
}
