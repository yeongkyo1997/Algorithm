import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int cnt;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            bw.write(N - cnt + "\n");
        }
        bw.close();
    }

    static void dfs(int x) {
        visited[x] = true;
        int next = arr[x];
        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int i = next; i != x; i = arr[i]) {
                cnt++;
            }
            cnt++;
        }
        finished[x] = true;
    }
}