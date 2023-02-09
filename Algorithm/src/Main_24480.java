import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_24480 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Map<Integer, PriorityQueue<Integer>> graph = new HashMap<>();
    static int N;
    static int M;
    static int R;
    static int[] result;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        result = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph.put(i, new PriorityQueue<>(((o1, o2) -> o2 - o1)));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(b);
        }
        dfs(R);
        for (int i = 1; i < N + 1; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int n) {
        result[n] = cnt++;

        while (!graph.get(n).isEmpty()) {
            if (result[graph.get(n).peek()] == 0)
                dfs(graph.get(n).peek());
            graph.get(n).poll();
        }
    }
}
