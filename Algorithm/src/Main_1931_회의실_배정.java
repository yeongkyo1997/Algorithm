import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1931_회의실_배정 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b));
        }
        int cnt = 1;

        Node cur = pq.poll();
        while (!pq.isEmpty()) {
            Node next = pq.poll();

            if (cur.b <= next.a) {
                cur = new Node(next.a, next.b);
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            if (b == o.b) return a - o.a;
            return b - o.b;
        }
    }
}
