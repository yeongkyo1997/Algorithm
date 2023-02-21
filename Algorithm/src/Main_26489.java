import java.io.*;
import java.util.StringTokenizer;

public class Main_26489 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int result = 0;

        while (true) {
            String str = br.readLine();
            if (str == null) break;
            result++;
        }
        bw.write(result + "");
        bw.close();
    }
}
