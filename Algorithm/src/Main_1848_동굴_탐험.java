import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1848_동굴_탐험 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[] dist, dist2, P;
    static int[][] edges1, edges2;
    static int INF = 987654321;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges1 = new int[N + 1][N + 1];
        edges2 = new int[N + 1][N + 1];
        dist = new int[N + 1];
        dist2 = new int[N + 1];
        P = new int[N + 1];

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            edges1[A][B] = C;
            edges1[B][A] = D;

            edges2[A][B] = D;
            edges2[B][A] = C;
        }

        IntStream.rangeClosed(1, N).forEach(i -> dist[i] = INF);

        dist[1] = 0;
        for (int i = 1; i <= N; ++i) {
            if (edges1[1][i] != 0) {
                pq.add(new Node(edges1[1][i], i, i));
                dist[i] = edges1[1][i];
            }
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dist[current.v] < current.w) continue;
            P[current.v] = current.p;

            for (int i = 1; i <= N; ++i) {
                if (edges1[current.v][i] != 0 && dist[i] > edges1[current.v][i] + current.w) {
                    dist[i] = edges1[current.v][i] + current.w;
                    pq.add(new Node(dist[i], i, current.p));
                }
            }
        }

        int result = INF;
        for (int i = 1; i <= N; ++i) {
            if (edges2[1][i] != 0) {
                int color = i;
                for (int j = 1; j <= N; ++j) {
                    dist2[j] = INF;
                }

                pq.add(new Node(edges2[1][i], color, 1));
                dist2[color] = edges2[1][i];
                dist2[1] = 0;

                while (!pq.isEmpty()) {
                    Node current = pq.poll();

                    if (dist2[current.v] < current.w) continue;
                    if (P[current.v] != color) {
                        result = Math.min(result, current.w + dist[current.v]);
                        continue;
                    }

                    for (int j = 1; j <= N; ++j) {
                        if (edges2[current.v][j] != 0 && dist2[j] > edges2[current.v][j] + current.w) {
                            dist2[j] = edges2[current.v][j] + current.w;
                            pq.add(new Node(dist2[j], j, 1));
                        }
                    }

                    if (current.v == color) dist2[1] = INF;
                }
            }

        }

        bw.write(result + "\n");
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int w, v, p;

        public Node(int w, int v, int p) {
            this.w = w;
            this.v = v;
            this.p = p;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}