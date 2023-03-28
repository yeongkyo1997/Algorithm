import java.io.*;
import java.util.StringTokenizer;

public class Main_1167_트리의_지름 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int max = 0;
    static int maxIdx = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                map[start][end] = weight;
            }
        }
        bfs(1);
        visited = new boolean[N + 1];
        max = 0;
        bfs(maxIdx);
        bw.write(max + "\n");
        bw.close();
    }

    static void bfs(int start) {
        visited[start] = true;
        for (int i = 1; i <= N; i++) {
            if (map[start][i] != 0 && !visited[i]) {
                visited[i] = true;
                map[start][i] += map[start][start];
                if (max < map[start][i]) {
                    max = map[start][i];
                    maxIdx = i;
                }
                bfs(i);
            }
        }
    }
}
