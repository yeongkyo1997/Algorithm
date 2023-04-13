import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int result = 0;
    private static int N;
    private static int M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, N).forEach(i -> arr[i] = Integer.parseInt(st.nextToken()));

        combi(0, 0, 0);
        bw.write(String.valueOf(result));
        bw.close();
    }

    static void combi(int start, int depth, int sum) {
        if (depth == 3) {
            if (sum <= M) {
                result = Math.max(result, sum);
            }
            return;
        }
        for (int i = start; i < N; i++) {
            combi(i + 1, depth + 1, sum + arr[i]);
        }
    }
}