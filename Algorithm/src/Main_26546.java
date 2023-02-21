import java.io.*;
import java.util.StringTokenizer;

public class Main_26546 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int sum = 0;
        while (t-- != 0) sum += Integer.parseInt(br.readLine());
        bw.write(sum + "");
        bw.close();
    }
}
