import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        while (N != 0) {
            if (N % 100 == 10) {
                result += 10;
                N /= 100;
            } else {
                result += N % 10;
                N /= 10;
            }
        }
        bw.write(result + "");
        bw.close();
    }
}