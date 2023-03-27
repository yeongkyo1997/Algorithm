import java.io.*;
import java.util.StringTokenizer;

public class Main_1865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int[][] edges;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            edges = new int[M + W][3];
            dist = new int[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[i][0] = S;
                edges[i][1] = E;
                edges[i][2] = T;
                edges[i + M][0] = E;
                edges[i + M][1] = S;
                edges[i + M][2] = T;
            }
            for (int i = M; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[i + W][0] = S;
                edges[i + W][1] = E;
                edges[i + W][2] = -T;
            }

            bw.write(bellmanFord(N) ? "YES\n" : "NO\n");
        }
        bw.close();
    }

    private static boolean bellmanFord(int N) {
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        for (int i = 1; i <= N; i++) {
            for (int[] edge : edges) {
                int S = edge[0];
                int E = edge[1];
                int T = edge[2];
                if (dist[S] != Integer.MAX_VALUE && dist[E] > dist[S] + T) {
                    dist[E] = dist[S] + T;
                    if (i == N) return true;
                }
            }
        }
        return false;
    }
}

