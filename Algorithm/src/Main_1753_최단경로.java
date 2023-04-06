import java.io.*;
import java.util.*;

public class Main_1753_최단경로 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dist;
    static int v, e, k;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < v + 1; i++)
            graph.add(new ArrayList<>());

        dist = new int[v + 1];

        int INF = 987654321;
        Arrays.fill(dist, INF);

        for (int i = 0; i < e; i++) {
            int u, v, w;
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        dijstra();

        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == INF) bw.write("INF\n");
            else bw.write(dist[i] + "\n");
        }
        bw.close();
    }

    static void dijstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[k] = 0;
        pq.add(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.v] < cur.cost) continue;

            for (int i = 0; i < graph.get(cur.v).size(); i++) {
                Node nextNode = graph.get(cur.v).get(i);

                if (dist[nextNode.v] > cur.cost + nextNode.cost) {
                    dist[nextNode.v] = cur.cost + nextNode.cost;
                    pq.add(new Node(nextNode.v, dist[nextNode.v]));
                }
            }
        }
    }

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
}
