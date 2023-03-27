import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_16398 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] parent;
    static Node[] list;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable<Node> {
        int start;
        int end;
        long value;

        public Node(int start, int end, long value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.value - o.value);
        }
    }

    static void init() {
        parent = new int[N + 1];
        IntStream.range(1, N + 1).forEach(i -> parent[i] = i);
    }

    static int find(int a) {
        return a == parent[a] ? a : (parent[a] = find(parent[a]));
    }

    static void union(int a, int b) {
        int aRoot = parent[a];
        int bRoot = parent[b];

        if (aRoot != bRoot) parent[aRoot] = bRoot;
    }

    static long kru() {
        int cnt = 0;
        long result = 0L;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int a = find(cur.start);
            int b = find(cur.end);


            if (parent[a] == parent[b]) continue;

            union(a, b);
            result += cur.value;
            if (++cnt == N) break;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        init();
        list = new Node[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                list[i] = new Node(i, j, Integer.parseInt(st.nextToken()));
                if (i != j) pq.add(list[i]);
            }
        }
        bw.write(kru() + "");
        bw.close();
    }
}
