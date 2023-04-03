import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String a = br.readLine();
        String b = br.readLine();
        if (a.length() >= b.length()) bw.write("go\n");
        else bw.write("no\n");
        bw.close();
    }
}