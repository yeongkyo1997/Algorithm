import java.io.*;
import java.util.*;

public class Main_1504_특정한_최단_경로 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int E;
    static int[] dist;
    static List<List<Node>> graph = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int v, cost;

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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int a, b, c;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int u, v;
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        dijkstra(1);
        int sTou = dist[u];
        int sTov = dist[v];

        dijkstra(u);
        int uTov = dist[v];
        int uTon = dist[N];

        dijkstra(v);
        int vTou = dist[u];
        int vTon = dist[N];

        int result = 987654321;

        result = Math.min(sTou + uTov + vTon, result);
        result = Math.min(sTov + vTou + uTon, result);

        if (vTou == 987654321 || result == 987654321) result = -1;
        bw.write(String.valueOf(result));
        bw.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N + 1];
        Arrays.fill(dist, 987654321);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        boolean[] check = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!check[cur.v]) check[cur.v] = true;

            for (Node node : graph.get(cur.v)) {
                if (dist[node.v] > dist[cur.v] + node.cost) {
                    dist[node.v] = dist[cur.v] + node.cost;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }
    }
}