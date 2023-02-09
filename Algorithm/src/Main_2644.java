import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int a;
    static int b;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            map.put(i, new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map.get(x).add(y);
            map.get(y).add(x);
        }
    }

    static void dfs(int n, int depth) throws IOException {
        if (n == b) {
            bw.write(depth + "\n");
            return;
        }
        for (int i : map.get(n)) {
            
        }
    }
}
