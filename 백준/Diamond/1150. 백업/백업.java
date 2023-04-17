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

    static int N, K, S1, S2;
    static int[] dist = new int[100002];
    static int[] left = new int[100002];
    static int[] right = new int[100002];
    static boolean[] visited = new boolean[100002];
    static PriorityQueue<Node> PQ = new PriorityQueue<Node>();

    static class Node implements Comparable<Node> {
        int dist;
        int idx;

        Node(int dist, int idx) {
            this.dist = dist;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist[1] = dist[N + 1] = 1000000000;
        right[1] = 2;
        left[N + 1] = N;
        PQ.add(new Node(1000000000, 1));
        PQ.add(new Node(1000000000, N + 1));

        st = new StringTokenizer(br.readLine());
        S1 = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) {
            S2 = Integer.parseInt(br.readLine());
            dist[i] = S2 - S1;
            PQ.add(new Node(dist[i], i));
            left[i] = i - 1;
            right[i] = i + 1;
            S1 = S2;
        }
        int ret = 0;

        while (K-- > 0) {
            while (visited[PQ.peek().idx]) PQ.poll();
            int d = PQ.peek().dist;
            int idx = PQ.peek().idx;
            PQ.poll();
            ret += d;
            dist[idx] = dist[left[idx]] + dist[right[idx]] - dist[idx];
            PQ.add(new Node(dist[idx], idx));
            visited[left[idx]] = visited[right[idx]] = true;
            left[idx] = left[left[idx]];
            right[idx] = right[right[idx]];
            right[left[idx]] = idx;
            left[right[idx]] = idx;
        }
        bw.write(ret + "\n");
        bw.close();
    }
}