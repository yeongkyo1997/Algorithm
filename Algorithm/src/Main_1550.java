import java.io.*;
import java.util.StringTokenizer;

public class Main_1550 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        bw.write(Integer.parseInt(str, 16) + "");
        bw.close();
    }
}
