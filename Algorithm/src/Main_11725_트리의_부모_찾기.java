
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11725_트리의_부모_찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] parent = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int[][] node = new int[100001][2];

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (node[a][0] == 0) {
                node[a][0] = b;
            } else {
                node[a][1] = b;
            }
            if (node[b][0] == 0) {
                node[b][0] = a;
            } else {
                node[b][1] = a;
            }
        }
        dfs(1);
        for (int i = 2; i <= n; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.close();
    }

    public static void dfs(int x) {
        visited[x] = true;
        if (node[x][0] != 0 && !visited[node[x][0]]) {
            parent[node[x][0]] = x;
            dfs(node[x][0]);
        }
        if (node[x][1] != 0 && !visited[node[x][1]]) {
            parent[node[x][1]] = x;
            dfs(node[x][1]);
        }
    }
}