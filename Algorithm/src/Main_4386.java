import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4386 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] parent;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int V;
    static int E;

    static class Pair {
        int num;
        double x;
        double y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getDistance(Pair o) {
            double x1 = this.x;
            double y1 = this.y;
            double x2 = o.x;
            double y2 = o.y;

            return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        }
    }

    static class Node implements Comparable<Node> {
        double start;
        double end;
        double value;

        public Node(double start, double end, double value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.value - o.value);
        }
    }

    static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(a);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        while (!pq.isEmpty()) {
        }
    }

    static void init() {
        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++)
            parent[i] = i;
    }

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
        }
    }
}
