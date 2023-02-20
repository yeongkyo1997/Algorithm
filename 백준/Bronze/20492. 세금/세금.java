import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int a = (int) (N * (1 - 22 / 100.));
        int b = (int) (((N * 0.8) + (N * 0.2)) - (N * 0.2 * 0.22));
        bw.write(String.format("%d %d ", a, b));
        bw.close();
    }
}