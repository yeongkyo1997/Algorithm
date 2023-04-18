import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        bw.write(String.valueOf(bfs()));
        bw.close();
    }

    static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                return visited[K];
            }

            if (cur * 2 > 0 && cur * 2 <= 100000 && visited[cur * 2] == 0) {
                visited[cur * 2] = visited[cur] + 1;
                queue.add(cur * 2);
            }
            if (cur - 1 >= 0 && cur - 1 <= 100000 && visited[cur - 1] == 0) {
                visited[cur - 1] = visited[cur] + 1;
                queue.add(cur - 1);
            }
            if (cur + 1 >= 0 && cur + 1 <= 100000 && visited[cur + 1] == 0) {
                visited[cur + 1] = visited[cur] + 1;
                queue.add(cur + 1);
            }
        }
        return visited[K];
    }
}