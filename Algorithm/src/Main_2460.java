import java.io.*;
import java.util.StringTokenizer;

public class Main_2460 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cur += b - a;

            max = Math.max(max, cur);
        }
        bw.write(max + "\n");
        bw.close();
    }
}
