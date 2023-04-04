import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1197_최소_스패닝_트리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] parent;
    private static int V;
    private static int E;

    static class Node implements Comparable<Node> {
        int start, end, cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        List<Node> graph = new ArrayList<>();


        parent = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            int a, b, c;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.add(new Node(a, b, c));
        }

        Collections.sort(graph);
        int result = 0;
        for (Node node : graph) {
            int a = node.start;
            int b = node.end;
            int c = node.cost;

            if (union(a, b)) result += c;
        }
        bw.write(result + "");
        bw.close();
    }

    static int find(int a) {
        if (parent[a] == a) return a;

        parent[a] = find(parent[a]);
        return parent[a];
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        parent[Math.max(a, b)] = Math.min(a, b);
        return true;
    }
}
