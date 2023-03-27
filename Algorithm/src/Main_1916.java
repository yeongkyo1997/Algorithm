import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Main_1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Node>[] graph;
    static long[] dist;
    static boolean[] visited;

    static class Node {
        int v;
        long cost;

        public Node(int v, long cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> (int) (o1.cost - o2.cost)));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!visited[cur.v]) visited[cur.v] = true;

            for (Node next : graph[cur.v]) {
                if (!visited[next.v] && dist[next.v] > cur.cost + next.cost) {
                    dist[next.v] = cur.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        dist = new long[N + 1];

        range(1, N + 1).forEach(i -> graph[i] = new ArrayList<>());
        range(1, N + 1).forEach(i -> dist[i] = Long.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        bw.write(dist[end] + "");

        bw.close();
    }
}
