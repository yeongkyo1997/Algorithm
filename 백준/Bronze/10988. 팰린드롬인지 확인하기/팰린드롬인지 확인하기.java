import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder(br.readLine());

        if (sb.toString().equals(sb.reverse().toString())) bw.write(1 + "");
        else bw.write(0 + "");
        bw.close();
    }
}