import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, V;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        visited = new boolean[N + 1];
        bw.write("\n");
        bfs();
        bw.close();
    }

    static void bfs() throws Exception {
        Queue<Integer> q = new LinkedList<>();
        bw.write(V + " ");
        visited[V] = true;
        q.offer(V);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer val : graph[cur]) {
                if (!visited[val]) {
                    bw.write(val + " ");
                    visited[val] = true;
                    q.offer(val);
                }
            }
        }
    }

    static void dfs(int v) throws Exception {
        if (visited[v])
            return;
        bw.write(v + " ");
        visited[v] = true;
        for (Integer val : graph[v]) {
            dfs(val);
        }
    }
}