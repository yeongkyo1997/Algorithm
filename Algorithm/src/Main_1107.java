import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1107 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int num;
        int depth;

        public Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }

        @Override
        public int compareTo(Node o) {
            if (this.depth == o.depth) return o.num - this.num;
            return this.depth - o.depth;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] nop = new boolean[10];
        visited = new boolean[500001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nop[Integer.parseInt(st.nextToken())] = true;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(100, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.num == N) {
                bw.write(cur.depth + "");
                break;
            }
            for (int i = 0; i < 10; i++) {
                if (nop[i]) continue;
                StringBuilder sb = new StringBuilder(String.valueOf(cur.num));


                StringBuilder tmp = sb.append(i);
                if (tmp.toString().compareTo("500001") > 0) {
                    int next = Integer.parseInt(sb.toString());
                    if (next <= 500000) {
                        if (!visited[next])
                            pq.add(new Node(next, cur.depth + 1));
                    }
                } else break;
            }

            if (cur.num + 1 <= 500000 && !visited[cur.num + 1]) {
                pq.add(new Node(cur.num + 1, cur.depth + 1));
            }
            if (cur.num - 1 >= 0 && !visited[cur.num - 1])
                pq.add(new Node(cur.num - 1, cur.depth + 1));
        }
        bw.close();
    }
}
