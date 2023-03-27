import java.io.*;
import java.util.StringTokenizer;

public class Main_2758_로또 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int M;
    private static int[] dp;
    static int cnt;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new int[M + 1];
            cnt = 0;
            combi(0, 1);
            System.out.println(cnt);
        }
    }

    static void combi(int depth, int start) {
        if (depth == N) {
            cnt++;
        }

        for (int i = start; i < M + 1; i++) {
            combi(depth + 1, i * 2);
        }
    }
}
