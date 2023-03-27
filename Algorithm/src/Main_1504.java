import java.io.*;
import java.util.StringTokenizer;

public class Main_1504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int E;
    private static int[][] map;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        floyd();

        int result = getMin(map[1][v1] + map[v1][v2] + map[v2][N], map[1][v2] + map[v2][v1] + map[v1][N]);
        if (result == 0) bw.write(-1 + "");
        else bw.write(result + "");
        bw.close();
    }

    public static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] != 0 && map[k][j] != 0) {
                        if (map[i][j] == 0) {
                            map[i][j] = map[i][k] + map[k][j];
                        } else {
                            map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                        }
                    }
                }
            }
        }
    }

    public static int getMin(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return Math.min(a, b);
    }
}
