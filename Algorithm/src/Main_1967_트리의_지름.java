import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1967_트리의_지름 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, u, v, cost;
    static int node, result;
    static boolean visited[];
    static ArrayList<Pair>[] graph;

    static class Pair {
        int node, cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static void DFS(int x, int dist) {
        visited[x] = true;

        if (dist > result) {
            result = dist;
            node = x;
        }

        for (int i = 0; i < graph[x].size(); i++) {
            int next_node = graph[x].get(i).node;
            int next_dist = graph[x].get(i).cost + dist;
            if (!visited[next_node]) {
                visited[next_node] = true;
                DFS(next_node, next_dist);
                visited[next_node] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph[u].add(new Pair(v, cost));
            graph[v].add(new Pair(u, cost));
        }

        DFS(1, 0);
        result = 0;
        for (int i = 1; i <= n; i++)
            visited[i] = false;
        DFS(node, 0);
        bw.write(result + "\n");
        bw.close();
    }
}