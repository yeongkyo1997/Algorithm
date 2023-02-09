import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N, K;
        int[] visited;
        Queue<Integer> queue = new LinkedList<>();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        Arrays.fill(visited, 100001);
        int fast = 100001;
        int cnt = 0;

        queue.add(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (fast > visited[cur] && cur == K) {
                fast = visited[cur];
                cnt = 0;
            } else if (fast == visited[cur] && cur == K) {
                cnt++;
            }

            if (cur + 1 <= K && visited[cur + 1] >= visited[cur] + 1) {
                visited[cur + 1] = visited[cur] + 1;
                queue.add(cur + 1);
            }
            if (cur - 1 >= 0 && visited[cur - 1] >= visited[cur] + 1) {
                visited[cur - 1] = visited[cur] + 1;
                queue.add(cur - 1);
            }
            if (cur * 2 <= K && visited[cur * 2] >= visited[cur] + 1) {
                visited[cur * 2] = visited[cur] + 1;
                queue.add(cur * 2);
            }
        }
        bw.write(fast + "\n");
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}
