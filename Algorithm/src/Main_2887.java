import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ 2887 - 행성 터널
public class Main_2887 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] parent;
    static int[] cost;
    static int[][] planets;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        cost = new int[N];
        planets = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            planets[i][0] = Integer.parseInt(st.nextToken());
            planets[i][1] = Integer.parseInt(st.nextToken());
            planets[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int x = Math.abs(planets[i][0] - planets[j][0]);
                int y = Math.abs(planets[i][1] - planets[j][1]);
                int z = Math.abs(planets[i][2] - planets[j][2]);
                pq.add(new Edge(i, j, Math.min(x, Math.min(y, z))));
            }
        }

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int result = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                result += edge.cost;
            }
        }

        bw.write(result + "\n");
        bw.close();
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (cost[x] < cost[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if (cost[x] == cost[y]) {
                cost[x]++;
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}