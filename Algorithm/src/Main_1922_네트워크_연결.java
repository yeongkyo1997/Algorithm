import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922_네트워크_연결 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] parent;
    static int V;
    static int E;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int value;

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
        else return;
    }

    static int kru() {
        int result = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int a = find(cur.start);
            int b = find(cur.end);

            if (a == b)
                continue;
            union(a, b);
            result += cur.value;

            if (++cnt == V)
                break;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        init();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        bw.write(kru() + "");
        bw.close();
    }
}
