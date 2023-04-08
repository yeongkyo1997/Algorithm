import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, X;
    static int[] dist;
    static int[] revDist;
    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Node>> revGraph = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int n, cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        revDist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(revDist, Integer.MAX_VALUE);

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            revGraph.get(b).add(new Node(a, c));

        }
        dijkstra(graph, dist, X);
        dijkstra(revGraph, revDist, X);

        int result = 0;
        for (int i = 1; i < N + 1; i++) result = Math.max(dist[i] + revDist[i], result);

        bw.write(String.valueOf(result));
        bw.close();
    }

    static void dijkstra(List<List<Node>> list, int[] dist, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[n] = 0;
        pq.add(new Node(n, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.n]) continue;

            for (Node node : list.get(cur.n)) {
                if (dist[node.n] > dist[cur.n] + node.cost) {
                    dist[node.n] = dist[cur.n] + node.cost;
                    pq.add(new Node(node.n, dist[node.n]));
                }
            }
        }
    }
}