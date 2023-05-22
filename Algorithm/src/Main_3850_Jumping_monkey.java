import java.io.*;
import java.util.*;

public class Main_3850_Jumping_monkey {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAXN = 21;
    private static final int INF = (int) 1e9;

    private static final int[] dist = new int[1 << MAXN];
    private static final int[] pre = new int[1 << MAXN];
    private static final int[] shoot = new int[1 << MAXN];
    private static int n, m;
    private static final ArrayList<Integer>[] adjacent = new ArrayList[MAXN];
    private static final int[] counter = new int[MAXN];

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            if (n == 0 && m == 0) break;
            for (int i = 0; i < n; ++i) {
                adjacent[i] = new ArrayList<>();
            }
            int a, b;
            for (int i = 0; i < m; ++i) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                adjacent[a].add(b);
                adjacent[b].add(a);
            }

            int res = bfs();

            if (res == INF) {
                bw.write("Impossible\n");
                continue;
            }
            bw.write(res + ":");
            print(0);
            bw.write("\n");
        }
        bw.close();
    }

    static int bfs() {
        int cur_state, next_state, i;
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, -1);
        dist[(1 << n) - 1] = 0;
        q.add((1 << n) - 1);

        while (!q.isEmpty()) {
            int p = q.poll();
            cur_state = 0;
            Arrays.fill(counter, 0);
            for (i = 0; i < n; ++i) {
                if ((p & (1 << i)) != 0) {
                    for (int next : adjacent[i]) {
                        counter[next]++;
                        cur_state |= (1 << next);
                    }
                }
            }
            for (i = 0; i < n; ++i) {
                if ((p & (1 << i)) != 0) {
                    next_state = cur_state;
                    for (int next : adjacent[i]) {
                        if (counter[next] - 1 <= 0) next_state &= ~(1 << next);
                    }
                    if (dist[next_state] == -1) {
                        dist[next_state] = dist[p] + 1;
                        q.add(next_state);
                        pre[next_state] = p;
                        shoot[next_state] = i;
                        if (next_state == 0) return dist[next_state];
                    }
                }
            }
        }
        return INF;
    }

    static void print(int st) throws IOException {
        if (st == (1 << n) - 1) return;
        print(pre[st]);
        bw.write(" " + shoot[st]);
    }
}
