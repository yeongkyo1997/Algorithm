package dataStructure;

import java.io.*;
import java.util.*;

public class Dijkstra {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int M;
    private static int[] dist;
    static List<List<Node>> graph;

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

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        dist = new int[N + 1];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }
    }

    static void dijkstra(int v) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(v, 0));
        dist[v] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.v;
            int cost = node.cost;

            if (cost > dist[cur]) continue;

            for (Node ele : graph.get(cur)) {
                if (dist[ele.v] > cost + ele.cost) {
                    dist[ele.v] = cost + ele.cost;
                    pq.add(new Node(ele.v, cur + ele.cost));
                }
            }
        }
    }
}
