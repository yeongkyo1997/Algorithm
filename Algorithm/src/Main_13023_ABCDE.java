import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int N, M;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            int a, b;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        bw.write(String.valueOf(dfs(0)));
        bw.close();

    }

    static int dfs(int n) {
        if (n == 5) {
            return 1;
        }
        visited[n] = true;
        for (int i = 0; i < graph.get(n).size(); i++) {
            int next = graph.get(n).get(i);
            if (!visited[next]) {
                if (dfs(next) == 1) {
                    return 1;
                }
            }
        }
        visited[n] = false;
        return 0;
    }
}
