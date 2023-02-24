import java.io.*;
import java.util.StringTokenizer;

public class Main_1167 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
<<<<<<< HEAD
    private static int V;
    private static int[][] tree;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        tree = new int[V + 1][V + 1];

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[start][end] = weight;
            }
        }

        int[] result = dfs(1, new boolean[V + 1]);
        result = dfs(result[0], new boolean[V + 1]);
        bw.write(result[1] + "");

        bw.close();
    }

    static int[] dfs(int start, boolean[] visited) {
        visited[start] = true;
        int[] result = new int[2];
        for (int i = 1; i < V + 1; i++) {
            if (tree[start][i] != 0 && !visited[i]) {
                int[] temp = dfs(i, visited);
                if (result[1] < temp[1] + tree[start][i]) {
                    result[0] = i;
                    result[1] = temp[1] + tree[start][i];
                }
            }
        }
        return result;
    }
}
=======

    public static void main(String[] args) throws IOException {
        
    }
}
>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2
