import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325_효율적인_해킹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[][] arr;
    static int[] result;

    public static void main (String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        result = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[B][A] = 1;
        }

        for (int i = 1; i <= N; i++) result[i] = bfs(i);

        int max = 0;
        for (int i = 1; i <= N; i++) max = Math.max(max, result[i]);

        for (int i = 1; i <= N; i++) if (result[i] == max) bw.write(i + " ");
        bw.close();
    }


    static int bfs (int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        int cnt = 0;
        int[] visited = new int[N + 1];
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            cnt += 1;

            for (int i = 1; i <= N; i++) {
                if (arr[tmp][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
        return cnt;
    }
}
