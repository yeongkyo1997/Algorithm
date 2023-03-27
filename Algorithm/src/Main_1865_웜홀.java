import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1865_웜홀 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m, w;
    static int[] dist;
    static int[][] edges;

    static boolean time_travel(int n, int[][] edges) {
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                int s = edge[0];
                int e = edge[1];
                int t = edge[2];
                if (dist[e] > dist[s] + t) {
                    dist[e] = dist[s] + t;
                }
            }
        }

        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            int t = edge[2];
            if (dist[e] > dist[s] + t) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        int TC = Integer.parseInt(br.readLine());

        while (TC > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edges = new int[m * 2 + w][3];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges[i * 2][0] = s;
                edges[i * 2][1] = e;
                edges[i * 2][2] = t;
                edges[i * 2 + 1][0] = e;
                edges[i * 2 + 1][1] = s;
                edges[i * 2 + 1][2] = t;
            }
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges[m * 2 + i][0] = s;
                edges[m * 2 + i][1] = e;
                edges[m * 2 + i][2] = -t;
            }

            if (time_travel(n, edges)) bw.write("YES\n");
            else bw.write("NO\n");

            TC--;
        }
        bw.close();
    }
}
