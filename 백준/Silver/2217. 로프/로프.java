import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int max = IntStream.range(0, N)
                .map(i -> arr[i] * (N - i))
                .max()
                .orElse(0);
        bw.write(max + "\n");
        bw.flush();
    }
}