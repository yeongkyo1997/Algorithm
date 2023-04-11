import java.io.*;
import java.util.StringTokenizer;

public class Main_2902_KMP는_왜_KMP일까 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), "-");

        while (st.hasMoreTokens()) {
            bw.write(st.nextToken().charAt(0));
        }
        bw.close();
    }
}
