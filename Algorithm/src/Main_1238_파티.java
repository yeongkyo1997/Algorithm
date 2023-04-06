import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int[][] map;
    private static int n;

    static class Node {
        int x;
        int cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        int[] dist = new int[n + 1];
        int[] dist2 = new int[n + 1];
        int max = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = cost;
        }

        dijkstra(x, dist);

        for (int i = 1; i < n + 1; i++) {
            dijkstra(i, dist2);
            max = Math.max(max, dist[i] + dist2[x]);
        }
        bw.write(String.valueOf(max));
        bw.close();
    }

    static void dijkstra(int start, int[] dist) {
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.x]) continue;
            visited[node.x] = true;

            for (int i = 1; i < n + 1; i++) {
                if (map[node.x][i] != 0 && dist[i] > dist[node.x] + map[node.x][i]) {
                    dist[i] = dist[node.x] + map[node.x][i];
                    pq.add(new Node(i, dist[i]));
                }
            }
        }
    }
}