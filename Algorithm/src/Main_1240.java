import java.io.*;
import java.util.StringTokenizer;

// BOJ 1240번 노드사이의 거리
public class Main_1240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[from][to] = weight;
            map[to][from] = weight;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(dfs(start, end) + "\n");
        }
        bw.close();
    }

    // dfs를 이용하여 start에서 end까지의 거리를 구한다.
    public static int dfs(int start, int end) {
        visited[start] = true;
        if (start == end) {
            return 0;
        }
        for (int i = 1; i <= N; i++) {
            if (map[start][i] != 0 && !visited[i]) {
                distance[i] = distance[start] + map[start][i];
                dfs(i, end);
            }
        }
        return distance[end];

    }
}
