import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int a = br.readLine().length();
        int b = br.readLine().length();

        if (a >= b) bw.write("go" + "");
        else bw.write("no" + "");
        bw.close();
    }
}