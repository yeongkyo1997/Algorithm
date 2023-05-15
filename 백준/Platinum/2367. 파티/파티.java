import java.util.*;

public class Main {

    static final int INF = 987654321;
    static final int FOOD = 250;
    static int[][] c = new int[502][502];
    static int[][] f = new int[502][502];
    static List<Integer>[] adj = new List[502];
    static int S = 0, T = 500;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            c[S][i] = k;
            adj[S].add(i);
            adj[i].add(S);
        }

        for (int i = 1; i <= d; i++) {
            int val = sc.nextInt();
            c[i + FOOD][T] = val;
            adj[i + FOOD].add(T);
            adj[T].add(i + FOOD);
        }

        for (int i = 1; i <= n; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                int pos = sc.nextInt();
                c[i][pos + FOOD] = 1;
                adj[i].add(pos + FOOD);
                adj[pos + FOOD].add(i);
            }
        }

        int totalFlow = 0;

        while (true) {
            int[] prev = new int[502];
            Arrays.fill(prev, -1);

            Queue<Integer> q = new LinkedList<>();
            q.add(S);

            while (!q.isEmpty() && prev[T] == -1) {
                int here = q.poll();

                for (int i = 0; i < adj[here].size(); i++) {
                    int next = adj[here].get(i);
                    if (prev[next] != -1)
                        continue;

                    if (c[here][next] - f[here][next] > 0) {
                        q.add(next);
                        prev[next] = here;
                    }
                }
            }

            if (prev[T] == -1)
                break;

            int flow = INF;

            for (int i = T; i != S; i = prev[i])
                flow = Math.min(flow, c[prev[i]][i] - f[prev[i]][i]);

            for (int i = T; i != S; i = prev[i]) {
                f[prev[i]][i] += flow;
                f[i][prev[i]] -= flow;
            }
            totalFlow += flow;
        }

        System.out.println(totalFlow);
    }
}