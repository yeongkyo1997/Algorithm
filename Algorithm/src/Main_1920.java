import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] list1 = IntStream.range(0, N).map(i -> Integer.parseInt(st.nextToken())).toArray();
        Arrays.sort(list1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreElements()) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(Arrays.binarySearch(list1, num) >= 0 ? 1 + "\n" : 0 + "\n");
        }
        bw.close();
    }
}
