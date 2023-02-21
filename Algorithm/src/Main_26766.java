import java.io.*;
import java.util.StringTokenizer;

public class Main_26766 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        while (N-- != 0)
            bw.write(" @@@   @@@ \n" + "@   @ @   @\n" + "@    @    @\n" + "@         @\n" + " @       @ \n" + "  @     @  \n" + "   @   @   \n" + "    @ @    \n" + "     @     \n" + "");

        bw.close();
    }
}
