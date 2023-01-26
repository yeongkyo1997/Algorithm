import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static PriorityQueue<Node> pq;
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;
    static List<Node> graph[];

    static class Node {
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

    }

    public static void main(String[] args) throws IOException {
        int V, E;
        int K;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(((o1, o2) -> {
            return o1.dist - o2.dist;
        }));

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        graph = new ArrayList[V + 1];

        for (int i = 1; i < V + 1; i++) {
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u, v, w;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
    }

    void dijkstra(int n) {
        dist[n] = 0;
        pq.add(new Node(n, 0));

        while (!pq.isEmpty()) {

        }
    }
}
