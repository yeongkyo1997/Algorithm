import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            int a, b;
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split(",");
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[1]);
            bw.write(String.format("%d\n", a + b));
        }
        bw.close();
    }
}