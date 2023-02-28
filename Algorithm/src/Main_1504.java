import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from][to] = weight;
            graph[to][from] = weight;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        int result = Math.min(result1, result2);

        if (result == Integer.MAX_VALUE) bw.write(-1 + "");
        else bw.write(result + "");

        bw.close();
    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        pq.add(start);

        while (!pq.isEmpty()) {
            int cur = pq.poll();

            if (visited[cur]) continue;
            visited[cur] = true;

            for (int i = 1; i <= N; i++) {
                if (graph[cur][i] != 0 && dist[i] > dist[cur] + graph[cur][i]) {
                    dist[i] = dist[cur] + graph[cur][i];
                    pq.add(i);
                }
            }
        }
        if (dist[end] == Integer.MAX_VALUE) return -1;
        else return dist[end];
    }
}