import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1068_트리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, root, erase, result;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) root = i;
        }

        erase = Integer.parseInt(br.readLine());
        visited[erase] = true;

        dfs(root);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int cur) {
        if (visited[cur]) return;

        visited[cur] = true;
        boolean isLeaf = true;

        for (int i = 0; i < N; i++) {
            if (parent[i] == cur) {
                isLeaf = false;
                dfs(i);
            }
        }
        if (isLeaf) result++;
    }
}