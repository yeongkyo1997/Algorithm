import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_21300 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int result = IntStream.range(0, 6).map(i -> Integer.parseInt(st.nextToken())).sum();

        bw.write(result * 5 + "\n");
        bw.close();
    }
}
