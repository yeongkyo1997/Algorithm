import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14938_서강그라운드 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m, r;
    static int[] item;
    static int[][] map;

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
        r = Integer.parseInt(st.nextToken());
        item = new int[n + 1];
        map = new int[n + 1][n + 1];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = cost;
            map[end][start] = cost;
        }

        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, dijkstra(i));
        }
        bw.write(max + "");
        bw.close();
    }

    static int dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int sum = 0;

        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.x;
            int cost = node.cost;

            if (visited[x]) continue;
            visited[x] = true;

            for (int i = 1; i < n + 1; i++) {
                if (map[x][i] != 0 && dist[i] > cost + map[x][i]) {
                    dist[i] = cost + map[x][i];
                    pq.add(new Node(i, dist[i]));
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (dist[i] <= m) {
                sum += item[i];
            }
        }
        return sum;
    }
}
