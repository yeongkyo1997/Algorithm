import java.io.*;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Main_10819 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    static int result = -1000;
    private static int[] list;
    static int[] visited;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        visited = new int[N];
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        range(0, N).forEach(i -> list[i] = Integer.parseInt(st.nextToken()));
        perm(0, 0);
        bw.write(result + "");
        bw.close();
    }

    static void perm(int depth, int flag) {
        if (depth == N) {
            int sum = range(0, N - 1).map(i -> Math.abs(numbers[i] - numbers[i + 1])).sum();

            result = Math.max(sum, result);
            return;
        }
        range(0, N).filter(i -> (flag & 1 << i) == 0).forEach(i -> {
            numbers[depth] = list[i];
            perm(depth + 1, flag | 1 << i);
        });
    }
}
