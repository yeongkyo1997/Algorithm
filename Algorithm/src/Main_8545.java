import java.io.*;
import java.util.StringTokenizer;

public class Main_8545 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        for (int i = str.length() - 1; i >= 0; i--) bw.write(str.charAt(i) + "");
        bw.close();
    }
}
