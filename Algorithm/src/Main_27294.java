import java.io.*;
import java.util.StringTokenizer;

public class Main_27294 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        if (12 <= T && T <= 16 && S == 0) bw.write(320 + "");
        else bw.write(280 + "");
        bw.close();
    }
}
