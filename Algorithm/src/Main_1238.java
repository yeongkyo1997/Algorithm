import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Main_1238 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static boolean[] visited;
    private static int[] dist;
    private static int[] dist2;
    private static int[][] map;
    private static int x;
    private static int m;
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
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        dist = new int[n + 1];
        dist2 = new int[n + 1];
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
        bw.write(max + "");
        bw.close();
    }

    static void dijkstra(int start, int[] dist) {
        visited = new boolean[n + 1];

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

            range(1, n + 1).filter(i -> (map[node.x][i] != 0) && (dist[i] > (dist[node.x] + map[node.x][i]))).forEach(i -> {
                dist[i] = dist[node.x] + map[node.x][i];
                pq.add(new Node(i, dist[i]));
            });
        }
    }
}