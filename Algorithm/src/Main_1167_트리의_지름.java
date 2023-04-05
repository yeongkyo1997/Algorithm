import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main_1167_트리의_지름 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int V;
    static int[][] v;
    static int[] visited;
    static int maxdist = 0;
    static int maxnode;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        v = new int[V + 1][V + 1];
        visited = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            while (n1 != -1) {
                int n2 = Integer.parseInt(st.nextToken());
                v[num][n1] = n2;
                v[n1][num] = n2;
                n1 = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void dfs(int i, int dist) {
        if (visited[i] == 1) return;
        if (maxdist < dist) {
            maxdist = dist;
            maxnode = i;
        }
        visited[i] = 1;
        for (int j = 1; j <= V; j++) {
            if (v[i][j] != 0) {
                int nd = v[i][j];
                dfs(j, nd + dist);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        dfs(1, 0);
        visited = new int[V + 1];
        maxdist = 0;
        dfs(maxnode, 0);
        bw.write(maxdist + "\n");
        bw.close();
    }
}