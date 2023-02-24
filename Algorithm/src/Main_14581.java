import java.io.*;
import java.util.StringTokenizer;

public class Main_14581 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        bw.write(String.format(":fan::fan::fan:\n" + ":fan::%s::fan:\n" + ":fan::fan::fan:", str) + "");
        bw.close();
    }
}
