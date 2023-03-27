import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Main_1922 {
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
        range(1, V + 1).forEach(i -> parent[i] = i);
    }

    static int find(int a) {
        return a == parent[a] ? a : (parent[a] = find(parent[a]));
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) parent[aRoot] = bRoot;
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
