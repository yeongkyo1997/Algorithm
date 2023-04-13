import java.io.*;
import java.util.StringTokenizer;

public class Main_9093_단어_뒤집기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                bw.write(sb.reverse().toString());
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
