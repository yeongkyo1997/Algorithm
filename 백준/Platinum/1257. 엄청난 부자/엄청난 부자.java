import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long M;
    static int N, S;
    static int[] arr = new int[1000];
    static int[] dp = new int[10000];

    public static void main(String[] args) throws Exception {
        M = Long.parseLong(br.readLine());
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        S = arr[0];

        for (int i = 1; i < N; i++) S = Math.max(S, arr[i]);
        for (int i = 1; i < S; i++) dp[i] = 1000000000;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            int cur = -pq.peek().x;
            int tpos = pq.peek().y;

            pq.poll();
            if (dp[tpos] != cur) continue;

            for (int i = 0; i < N; i++) {
                int t = tpos + arr[i];

                if (dp[t % S] > cur + 1 - t / S) {
                    dp[t % S] = cur + 1 - t / S;
                    pq.add(new Pair(-dp[t % S], t % S));
                }
            }
        }

        bw.write(String.valueOf(dp[(int) (M % S)] + M / S));
        bw.close();
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.x - o.x;
        }
    }
}