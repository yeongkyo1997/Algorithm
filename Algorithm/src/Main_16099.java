import java.io.*;
import java.util.StringTokenizer;

public class Main_16099 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        long a, b, c, d;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            c = Long.parseLong(st.nextToken());
            d = Long.parseLong(st.nextToken());
            if (a * b == c * d) bw.write("Tie" + "\n");
            else if (a * b > c * d) bw.write("TelecomParisTech" + "\n");
            else bw.write("Eurecom" + "\n");
        }
        bw.close();
    }
}
