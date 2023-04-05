import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928_뱀과_사다리_게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int M;
    private static int[] map;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[101];
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        bw.write(bfs() + "");
        bw.close();
    }

    private static int bfs() {
        dist = new int[101];
        visited = new boolean[101];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == 100) return dist[cur];
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;
                if (map[next] != 0) next = map[next];
                if (visited[next]) continue;
                visited[next] = true;
                dist[next] = dist[cur] + 1;
                queue.add(next);
            }
        }
        return -1;
    }
}
