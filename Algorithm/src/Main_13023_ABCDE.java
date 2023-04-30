import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static boolean[] visited;
    static boolean isPossible;
    static int[][] v;

    static void dfs(int node, int depth) {
        if (depth == 4) {
            isPossible = true;
            return;
        }

        visited[node] = true;

        for (int i = 0; i < N; i++) {
            if (v[node][i] == 1 && !visited[i] && !isPossible) {
                dfs(i, depth + 1);
            }
        }
        visited[node] = false;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v[a][b] = 1;
            v[b][a] = 1;
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (isPossible) break;
        }
        bw.write(isPossible ? "1" : "0");
        bw.close();
    }
}