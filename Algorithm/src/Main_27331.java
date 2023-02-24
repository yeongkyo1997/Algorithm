import java.io.*;
import java.util.StringTokenizer;

public class Main_27331 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        sb.append(a).append(b);

        bw.write(sb.toString() + "");
        bw.close();
    }
}
