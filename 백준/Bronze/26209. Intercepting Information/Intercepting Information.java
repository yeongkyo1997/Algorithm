import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals("9")) {
                System.out.println("F");
                return;
            }
        }
        System.out.println("S");
    }
}