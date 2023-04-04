import java.io.*;
import java.util.StringTokenizer;

public class Main_4101_크냐 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == b && a == 0) break;

            if (a > b) bw.write("Yes\n");
            else bw.write("No\n");
        }
        bw.close();
    }
}
