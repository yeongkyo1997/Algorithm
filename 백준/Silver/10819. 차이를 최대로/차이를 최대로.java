import java.io.*;
import java.util.StringTokenizer;

public class Main {
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
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        perm(0, 0);
        bw.write(result + "");
        bw.close();
    }

    static void perm(int depth, int flag) {
        if (depth == N) {
            int sum = 0;

            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(numbers[i] - numbers[i + 1]);
            }
            result = Math.max(sum, result);
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;
            numbers[depth] = list[i];
            perm(depth + 1, flag | 1 << i);
        }
    }
}