import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_14938 {
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

        st = new StringTokenizer(br.readLine());
        IntStream.range(1, n + 1).forEach(i -> item[i] = Integer.parseInt(st.nextToken()));

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = cost;
            map[end][start] = cost;
        }

        int max = IntStream.range(1, n + 1).map(Main_14938::dijkstra).max().getAsInt();
        bw.write(max + "");
        bw.close();
    }

    static int dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];
        int[] dist;
        int sum;

        dist = IntStream.range(1, n + 1).map(i -> Integer.MAX_VALUE).toArray();

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.x;
            int cost = node.cost;

            if (visited[x]) continue;
            visited[x] = true;

            IntStream.range(1, n + 1).filter(i -> map[x][i] != 0 && dist[i] > cost + map[x][i]).forEach(i -> {
                dist[i] = cost + map[x][i];
                pq.add(new Node(i, dist[i]));
            });
        }

        sum = IntStream.range(1, n + 1).filter(i -> dist[i] <= m).map(i -> item[i]).sum();
        return sum;
    }
}
