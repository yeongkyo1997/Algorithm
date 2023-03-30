import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1167_트리의_지름 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static ArrayList<Pair<Integer, Integer>>[] tree;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                tree[u].add(new Pair<>(v, w));
            }
        }
        Pair<Integer, Integer> farthest = dfs(1, 0);
        System.out.println(dfs(farthest.getKey(), 0).getValue());
    }

    static Pair<Integer, Integer> dfs(int start, int depth) {
        boolean[] visited = new boolean[n + 1];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        visited[start] = true;
        Pair<Integer, Integer> result = new Pair<>(start, depth);
        stack.push(result);
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> p = stack.pop();
            if (p.getValue() > result.getValue()) {
                result = p;
            }
            for (Pair<Integer, Integer> next : tree[p.getKey()]) {
                if (!visited[next.getKey()]) {
                    visited[next.getKey()] = true;
                    stack.push(new Pair<>(next.getKey(), p.getValue() + next.getValue()));
                }
            }
        }
        return result;
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
