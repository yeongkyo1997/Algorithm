import java.io.*;
import java.util.StringTokenizer;

public class Main_1761_정점들의_거리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[][] adj;
    static boolean[] visited;
    static int[][] length;
    static int[][] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        length = new int[N + 1][16];
        parent = new int[N + 1][16];
        depth = new int[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s][e] = w;
            adj[e][s] = w;
        }

        dfs(1, 0);
        connect();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(LCA(x, y) + "\n");
        }
        bw.flush();
    }

    static void dfs(int start, int n) {
        visited[start] = true;
        depth[start] = n;
        for (int i = 1; i <= N; i++) {
            int next = i;
            int weight = adj[start][i];

            if (visited[next]) continue;

            parent[next][0] = start;
            length[next][0] = weight;
            dfs(next, n + 1);
        }
    }

    static void connect() {
        for (int p = 1; p < 16; p++) {
            for (int cur = 1; cur <= N; cur++) {
                int prevParent = parent[cur][p - 1];
                parent[cur][p] = parent[prevParent][p - 1];

                if (parent[prevParent][p - 1] == 0) continue;

                int prevLength = length[cur][p - 1];
                length[cur][p] = prevLength + length[prevParent][p - 1];
            }
        }
    }

    static int LCA(int xNode, int yNode) {
        if (depth[xNode] > depth[yNode]) {
            int tmp = xNode;
            xNode = yNode;
            yNode = tmp;
        }
        int lenSum = 0;

        for (int i = 15; i >= 0; i--) {
            int jump = 1 << i;
            if (depth[yNode] - depth[xNode] >= jump) {
                lenSum += length[yNode][i];
                yNode = parent[yNode][i];
            }
        }

        if (xNode == yNode) return lenSum;

        for (int i = 15; i >= 0; i--) {
            if (parent[xNode][i] == parent[yNode][i]) continue;

            lenSum += length[xNode][i];
            xNode = parent[xNode][i];

            lenSum += length[yNode][i];
            yNode = parent[yNode][i];
        }

        lenSum += length[xNode][0] + length[yNode][0];
        return lenSum;
    }
}