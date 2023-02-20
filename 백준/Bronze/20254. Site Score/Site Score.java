import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int ur, tr, uo, to;
        st = new StringTokenizer(br.readLine());
        ur = Integer.parseInt(st.nextToken());
        tr = Integer.parseInt(st.nextToken());
        uo = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        int result = ur * 56 + 24 * tr + 14 * uo + 6 * to;
        bw.write(result + "");
        bw.close();
    }
}