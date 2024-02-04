import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int INF = (int) 1e9;
    static int V, E, K;
    static int[] dist;
    static List<Node>[] graph;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u, v, w;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF)
                bw.write("INF\n");
            else
                bw.write(dist[i] + "\n");
        }
        bw.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (curNode.weight > dist[curNode.end])
                continue;

            for (Node node : graph[curNode.end]) {
                if (dist[node.end] > dist[curNode.end] + node.weight) {
                    dist[node.end] = dist[curNode.end] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}