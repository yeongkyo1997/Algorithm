import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String S = br.readLine();

        int i = Integer.parseInt(br.readLine());

        bw.write(S.charAt(i - 1));
        bw.close();
    }
}