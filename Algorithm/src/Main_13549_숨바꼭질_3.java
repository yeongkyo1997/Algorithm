import java.io.*;
import java.util.*;

public class Main_13549_숨바꼭질_3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(visited, Integer.MAX_VALUE);
    }

    static void bfs() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((Comparator.comparingInt(o -> visited[o])));
        queue.add(N);
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int next = cur * 2;

            if (next > 0 && next <= 100000 && visited[cur] < visited[next]) {
                visited[next] = visited[cur] + 1;
                queue.add(next);
            }
        }
    }

    static boolean check(int cur, int next) {
    }
}
