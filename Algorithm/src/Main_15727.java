import java.io.*;
import java.util.StringTokenizer;

public class Main_15727 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int L = Integer.parseInt(br.readLine());

        bw.write(((L - 1) / 5 + 1) + "");
        bw.close();
    }
}
