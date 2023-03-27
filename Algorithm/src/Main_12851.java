import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        if (N == K) {
            bw.write(0 + "\n");
            bw.write(1 + "\n");
        } else {
            int[] result = bfs(N, K);
            bw.write(result[0] + "\n");
            bw.write(result[1] + "\n");
        }
        bw.close();
    }

    public static int[] bfs(int N, int K) {
        int[] result = new int[2];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        visited[N] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == K) {
                    result[0] = cnt;
                    result[1]++;
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    queue.add(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur + 1 <= 100000 && !visited[cur + 1]) {
                    queue.add(cur + 1);
                    visited[cur + 1] = true;
                }
                if (cur * 2 <= 100000 && !visited[cur * 2]) {
                    queue.add(cur * 2);
                    visited[cur * 2] = true;
                }
            }
            cnt++;
        }
        return result;
    }
}