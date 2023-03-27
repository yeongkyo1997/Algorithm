import java.io.*;
import java.util.StringTokenizer;

public class Main_1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int S;
    private static int N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[] list = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (start <= N && end <= N) {
            int distance = end - start;
            if (sum >= S && min > distance) min = distance;

            if (sum < S) sum += list[end++];
            else sum -= list[start++];
        }

        if (min == Integer.MAX_VALUE) bw.write(0 + "\n");
        else bw.write(min + "");
        bw.close();
    }
}