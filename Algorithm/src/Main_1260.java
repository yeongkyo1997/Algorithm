import java.io.*;
import java.util.*;

public class Main_1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }
        visited = new boolean[N + 1];
        dfs(V);
        bw.write("\n" + "");
        visited = new boolean[N + 1];
        bfs(V);
        bw.close();
    }

    static void bfs(int start) throws IOException {
        bw.write(start + " ");
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer ele : graph.get(cur)) {
                if (visited[ele]) continue;
                queue.add(ele);
                visited[ele] = true;
                bw.write(ele + " ");
            }
        }
    }

    static void dfs(int start) throws IOException {
        if (visited[start]) return;

        bw.write(start + " ");
        visited[start] = true;

        for (Integer ele : graph.get(start)) {
            if (visited[ele]) continue;
            dfs(ele);
        }
    }
}