import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1162_도로포장 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m, k;
    static int[][] road;
    static long[][] dist;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        road = new int[n + 1][n + 1];
        dist = new long[n + 1][k + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            road[u][v] = w;
            road[v][u] = w;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dist[i][j] = Long.MAX_VALUE;
            }
        }

        dist[1][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 1; l <= n; l++) {
                    if (road[i][l] != 0) {
                        if (j < k && dist[i][j] < dist[l][j + 1]) {
                            dist[l][j + 1] = dist[i][j];
                        }
                        if (dist[i][j] + road[i][l] < dist[l][j]) {
                            dist[l][j] = dist[i][j] + road[i][l];
                        }
                    }
                }
            }
        }

        long result = dist[n][0];
        for (int i = 1; i <= k; i++)
            result = Math.min(result, dist[n][i]);


        bw.write(String.valueOf(result));
        bw.close();
    }
}
