import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1647 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int V, E;
    static int[] parent;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable<Node> {
        int start, end, value;

        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }


    static void init() {
        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }
    }

    static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) parent[aRoot] = bRoot;
        Queue<Integer> queue = new ArrayDeque<>();
    }

    static int kru() {
        int result = 0;
        int cnt = 0;
        int max = -1;
        init();

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int a = find(cur.start);
            int b = find(cur.end);

            if (a == b) continue;
            union(a, b);
            result += cur.value;
            max = Math.max(max, cur.value);
            if (++cnt == E) break;
        }
        return result - max;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        bw.write(kru() + "");
        bw.close();
    }
}
