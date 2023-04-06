import java.io.*;
import java.util.StringTokenizer;

public class Main_1956_운동 {
    static final int INF = 987654321;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int V, E;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int[][] arr = new int[V + 1][V + 1];

        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i != j) arr[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                for (int k = 1; k < V + 1; k++) {
                    if (i == j) continue;

                    if (arr[i][j] > arr[i][k] + arr[k][j]) arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        int result = INF;

        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i == j) continue;

                if (arr[i][j] != INF && arr[j][i] != INF) result = Math.min(result, arr[i][j] + arr[j][i]);
            }
        }

        result = (result == INF) ? -1 : result;
        bw.write(String.valueOf(result));
        bw.close();
    }
}
