import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11779_최소비용_구하기_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;
    static int[][] map;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int x;
        int cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        dist = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (map[start][end] == 0) {
                map[start][end] = cost;
            } else {
                map[start][end] = Math.min(map[start][end], cost);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        bw.close();
    }

    static void dijkstra(int start, int end) throws IOException {
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.x;
            int cost = node.cost;

            if (visited[x]) {
                continue;
            }
            visited[x] = true;

            for (int i = 1; i < n + 1; i++) {
                if (map[x][i] != 0 && dist[i] > cost + map[x][i]) {
                    dist[i] = cost + map[x][i];
                    pq.add(new Node(i, dist[i]));
                }
            }
        }

        bw.write(dist[end] + "\n");
        int[] path = new int[n + 1];
        int idx = 0;
        int x = end;

        while (x != start) {
            for (int i = 1; i < n + 1; i++) {
                if (map[i][x] != 0 && dist[x] == dist[i] + map[i][x]) {
                    path[idx++] = x;
                    x = i;
                    break;
                }
            }
        }
        path[idx] = start;

        bw.write((idx + 1) + "\n");
        for (int i = idx; i >= 0; i--) {
            bw.write(path[i] + " ");
        }
    }
}
