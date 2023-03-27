import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389_케빈_베이컨의_6단계_법칙 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 1; i <= N; i++) {
            dist = new int[N + 1];
            visited = new boolean[N + 1];
            bfs(i);
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += dist[j];
            }
            if (min > sum) {
                min = sum;
                minIdx = i;
            }
        }
        bw.write(minIdx + "");
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[cur] + 1;
                    queue.add(i);
                }
            }
        }
    }
}