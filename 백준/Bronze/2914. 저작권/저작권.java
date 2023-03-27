import java.io.*;
import java.util.StringTokenizer;

public class Main_21300 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i < 6; i++) {
            result += Integer.parseInt(st.nextToken());
        }

        bw.write(result * 5 + "\n");
        bw.close();
    }
}
