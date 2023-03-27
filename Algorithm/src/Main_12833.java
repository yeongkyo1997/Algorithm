import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_12833 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int A, B, C;
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A ^= IntStream.range(0, C).map(i -> B).reduce(0, (a, b) -> a ^ b);

        bw.write(A + "\n");
        bw.flush();
        bw.close();
    }
}
