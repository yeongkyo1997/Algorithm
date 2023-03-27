import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_16435 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] list = IntStream.range(0, N).map(i -> Integer.parseInt(st.nextToken())).toArray();
        Arrays.sort(list);


        for (int i = 0; i < N; i++) {
            if (list[i] <= L) L++;
            else break;
        }
        bw.write(L + "");
        bw.close();
    }
}
