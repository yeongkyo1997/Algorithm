import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1269 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = IntStream.range(0, N).map(i -> Integer.parseInt(st.nextToken())).toArray();

        st = new StringTokenizer(br.readLine());
        int[] B = IntStream.range(0, M).map(i -> Integer.parseInt(st.nextToken())).toArray();

        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = (int) IntStream.range(0, M).filter(i -> Arrays.binarySearch(A, B[i]) < 0).count();

        cnt += IntStream.range(0, N).filter(i -> Arrays.binarySearch(B, A[i]) < 0).count();

        bw.write(cnt + "");
        bw.close();
    }
}
