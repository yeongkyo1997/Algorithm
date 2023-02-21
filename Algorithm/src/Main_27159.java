import java.io.*;
import java.util.StringTokenizer;

public class Main_27159 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int five = N / 5;
        int one = N % 5;

        for (int i = 0; i < five; i++)
            bw.write("V" + "");
        for (int i = 0; i < one; i++)
            bw.write("I" + "");

        bw.close();
    }
}
