import java.io.*;
import java.util.StringTokenizer;

public class Main_10156_과자 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long K, N, M;
        K = Long.parseLong(st.nextToken());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        long result = K * N - M;
        if (result < 0) result = 0;
        bw.write(result + "");
        bw.close();
    }
}
