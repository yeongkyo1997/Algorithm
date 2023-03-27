import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int[][] data;

    static class Vertex implements Comparable<Vertex> {
        int vertex;
        int cost;

        public Vertex(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }

    static PriorityQueue<Vertex> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        data = new int[N][N];

        boolean[] visited = new boolean[N];

        // 각 정점에 연결할 때 최소의 비용
        int[] minCost = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 정점의 최소 비용을 무한대로 설정
        Arrays.fill(minCost, Integer.MAX_VALUE);

        minCost[0] = 0; // 임의의 시작점
        long result = 0; // 최소신장트리의 비용

        // 시작점을 우선순위 큐에 넣는다.
        pq.offer(new Vertex(0, 0));
        int cnt = 0;

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            if (visited[v.vertex]) continue;
            visited[v.vertex] = true;
            result += v.cost;
            if (++cnt == N) break;

            // v와 연결된 정점들의 최소 비용을 갱신
            for (int i = 0; i < N; i++) {
                if (!visited[i] && data[v.vertex][i] != 0 && minCost[i] > data[v.vertex][i]) {
                    minCost[i] = data[v.vertex][i];
                    pq.offer(new Vertex(i, minCost[i]));
                }
            }
        }

        bw.write(result + "");
        bw.close();
    }
}