import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int A, I;
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        I = Integer.parseInt(st.nextToken());

        bw.write((A * (I - 1) + 1) + "");

        bw.close();
    }
}