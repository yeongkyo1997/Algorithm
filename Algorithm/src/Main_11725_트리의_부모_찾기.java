import java.io.*;
import java.util.StringTokenizer;

public class Main_11725_트리의_부모_찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }
        bfs(1);
        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.close();
    }

    static void bfs(int start) {
        visited[start] = true;
        for (int i = 1; i <= N; i++) {
            if (map[start][i] != 0 && !visited[i]) {
                visited[i] = true;
                parent[i] = start;
                bfs(i);
            }
        }
    }
}