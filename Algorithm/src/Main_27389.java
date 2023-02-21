import java.io.*;
import java.util.StringTokenizer;

public class Main_27389 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        double a = Double.parseDouble(br.readLine());
        bw.write(a / 4 + "");
        bw.close();
    }
}
