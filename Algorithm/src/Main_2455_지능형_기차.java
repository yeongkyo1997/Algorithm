import java.io.*;
import java.util.StringTokenizer;

public class Main_2455_지능형_기차 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int cur = 0;
        int result = 0;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cur += b;
            cur -= a;
            result = Math.max(cur, result);
        }

        bw.write(result + "");
        bw.close();
    }
}
