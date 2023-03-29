import java.io.*;
import java.util.StringTokenizer;

//cpp to java
public class Main_1916_최소비용_구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, src, dst;
    static int[][] g;
    static int[] dist;
    static boolean[] visited;
    static final int INF = 2147000000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        g = new int[N + 1][N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a][b] = c;
        }
        st = new StringTokenizer(br.readLine());
        src = Integer.parseInt(st.nextToken());
        dst = Integer.parseInt(st.nextToken());
        dijkstra();
        bw.write(dist[dst] + "");
        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }
        dist[src] = 0;
        for (int i = 1; i <= N; i++) {
            int min = INF;
            int minIdx = -1;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && min > dist[j]) {
                    min = dist[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = true;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && g[minIdx][j] != 0 && dist[j] > dist[minIdx] + g[minIdx][j]) {
                    dist[j] = dist[minIdx] + g[minIdx][j];
                }
            }
        }
    }
}