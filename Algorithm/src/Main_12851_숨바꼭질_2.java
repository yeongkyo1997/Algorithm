import java.io.*;
import java.util.*;

public class Main_12851_숨바꼭질_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K;
    static int[] visited = new int[100001];
    static int time;
    static int cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
        bw.write(time + "\n" + cnt);
        bw.close();
    }

    static void bfs() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> visited[o1] - visited[o2]));
        pq.add(N);
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[N] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll();

            if (cur == K) {
                time = visited[K];
                cnt++;
            }

            int nx = cur * 2;
            if (nx > 0 && nx <= 100000 && visited[cur] < visited[nx]) {
                visited[nx] = visited[cur] + 1;
                pq.add(nx);
            }

            nx = cur + 1;
            if (nx <= 100000 && visited[cur] < visited[nx]) {
                visited[nx] = visited[cur] + 1;
                pq.add(nx);
            }

            nx = cur - 1;
            if (nx >= 0 && visited[cur] < visited[nx]) {
                visited[nx] = visited[cur] + 1;
                pq.add(nx);
            }
        }
    }
}