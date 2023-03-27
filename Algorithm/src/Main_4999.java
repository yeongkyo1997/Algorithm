import java.io.*;
import java.util.StringTokenizer;

public class Main_4999 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int a = br.readLine().length();
        int b = br.readLine().length();

        bw.write(a >= b ? "go" + "" : "no" + "");
        bw.close();
    }
}
