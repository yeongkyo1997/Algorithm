import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }

        if (a == b) bw.write("0\n");
        else {
            bw.write((b - a - 1) + "\n");
            for (long i = a + 1; i < b; i++)
                bw.write(i + " ");
        }
        bw.close();
    }
}