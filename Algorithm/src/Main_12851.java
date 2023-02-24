import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MAX = 100000;
    static int[] dist = new int[MAX + 1];
    static int[] cnt = new int[MAX + 1];


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bfs(N, K);
        bw.write(dist[K] + "\n" + cnt[K]);
        bw.close();

    }

    static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;
        cnt[N] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) continue;
            if (cur - 1 >= 0 && dist[cur - 1] == 0) {
                queue.add(cur - 1);
                dist[cur - 1] = dist[cur] + 1;
                cnt[cur - 1] = cnt[cur];
            } else if (cur - 1 >= 0 && dist[cur - 1] == dist[cur] + 1) cnt[cur - 1] += cnt[cur];

            if (cur + 1 <= MAX && dist[cur + 1] == 0) {
                queue.add(cur + 1);
                dist[cur + 1] = dist[cur] + 1;
                cnt[cur + 1] = cnt[cur];
            } else if (cur + 1 <= MAX && dist[cur + 1] == dist[cur] + 1) cnt[cur + 1] += cnt[cur];
            if (cur * 2 <= MAX && dist[cur * 2] == 0) {
                queue.add(cur * 2);
                dist[cur * 2] = dist[cur] + 1;
                cnt[cur * 2] = cnt[cur];
            } else if (cur * 2 <= MAX && dist[cur * 2] == dist[cur] + 1) cnt[cur * 2] += cnt[cur];
        }
    }
}
