import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int[] a = IntStream.range(0, 3).map(i -> Integer.parseInt(st.nextToken())).toArray();

        Arrays.sort(a);

        for (int i : a) {
            bw.write(i + " ");
        }
        bw.close();
    }
}