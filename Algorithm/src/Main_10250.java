import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main_10250 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int H, N;
            H = parseInt(st.nextToken());
            st.nextToken();
            N = parseInt(st.nextToken());

            bw.write(N % H == 0 ? 1 + "" : N % H + "");
            bw.write("0" + (int) Math.ceil(N / (double) H) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
