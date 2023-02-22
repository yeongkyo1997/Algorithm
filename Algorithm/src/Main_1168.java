import java.io.*;
import java.util.StringTokenizer;

public class Main_1168 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long result = 1;

        for (long i = 2; i < N + 1; i++) {
            result = (result + K - 1) % i + 1;
        }
        bw.write(result + "");
        bw.close();
    }
}
