import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int start = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            if (Objects.equals(st.nextToken(), "0")) break;
            bw.write(String.format("Case %d: Sorting... done!\n", start++));
        }
        bw.close();
    }
}