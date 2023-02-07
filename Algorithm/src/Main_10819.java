import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10819 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    static int result;
    private static int[] lists;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        lists = new int[N];
        visited = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lists[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve(int idx, int depth, int sum) {
        if (depth == N) {
            result = Math.max(sum, result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                solve(0, depth + 1, sum + lists[i]);
                visited[i] = 1;
            }

            visited[i] = 0;
        }
    }
}
