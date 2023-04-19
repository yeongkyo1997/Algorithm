package dataStructure;

import java.io.*;
import java.util.*;

public class Dijkstra {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dist;
    static int V, E;
    static int K;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < V + 1; i++) {
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
        dijkstra();
        for (int i = 1; i < V + 1; i++) {
            bw.write(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i] + "\n");
        }
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[K] = 0;
        boolean[] visited = new boolean[V + 1];
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.v]) continue;
            visited[cur.v] = true;

            for (Node node : graph[cur.v]) {
                if (dist[node.v] > dist[cur.v] + node.cost) {
                    dist[node.v] = dist[cur.v] + node.cost;
                    pq.add(new Node(node.v, node.cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
