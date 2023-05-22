package 미제출;

import java.util.*;

public class Main_14390_타일_놓기 {

    private static final int S = 80800;
    private static final int T = 80801;
    private static final int SZ = 80808;
    private static int n, m;
    private static int[][][] id = new int[222][222][2];
    private static char[][] a = new char[222][222];
    private static Dinic flow = new Dinic();

    static class Dinic {
        int s, t;
        ArrayList<ArrayList<Edge>> g = new ArrayList<>();

        Dinic() {
            for (int i = 0; i < SZ; i++) {
                g.add(new ArrayList<>());
            }
        }

        void addEdge(int s, int e, int x) {
            g.get(s).add(new Edge(e, g.get(e).size(), x));
            g.get(e).add(new Edge(s, g.get(s).size() - 1, 0));
        }

        boolean bfs() {
            int[] lv = new int[SZ];
            Arrays.fill(lv, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            lv[s] = 0;
            while (!q.isEmpty()) {
                int v = q.poll();
                for (Edge i : g.get(v)) {
                    if (lv[i.v] == -1 && i.c > 0) {
                        q.add(i.v);
                        lv[i.v] = lv[v] + 1;
                    }
                }
            }
            return lv[t] != -1;
        }

        int dfs(int v, int tot) {
            if (v == t) return tot;
            for (Edge i : g.get(v)) {
                if (i.c > 0) {
                    int fl = dfs(i.v, Math.min(tot, i.c));
                    if (fl > 0) {
                        i.c -= fl;
                        g.get(i.v).get(i.dual).c += fl;
                        return fl;
                    }
                }
            }
            return 0;
        }

        int run(int _s, int _t) {
            s = _s;
            t = _t;
            int ret = 0;
            while (bfs()) {
                int tmp;
                while ((tmp = dfs(s, Integer.MAX_VALUE)) > 0) ret += tmp;
            }
            return ret;
        }

        class Edge {
            int v, dual, c;

            Edge(int v, int dual, int c) {
                this.v = v;
                this.dual = dual;
                this.c = c;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int pv = 0, cnt = 0;

        for (int i = 1; i <= n; i++) {
            String line = sc.next();
            for (int j = 1; j <= m; j++) {
                a[i][j] = line.charAt(j - 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == '.') {
                    cnt++;
                    if (a[i + 1][j] == '.') {
                        id[i][j][0] = ++pv;
                        flow.addEdge(S, pv, 1);
                    }
                    if (a[i][j + 1] == '.') {
                        id[i][j][1] = ++pv;
                        flow.addEdge(pv, T, 1);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == '.') {
                    if (id[i][j][0] > 0) {
                        if (id[i + 1][j - 1][1] > 0) {
                            flow.addEdge(id[i][j][0], id[i + 1][j - 1][1], 1);
                        }
                        if (id[i + 1][j][1] > 0) {
                            flow.addEdge(id[i][j][0], id[i + 1][j][1], 1);
                        }
                    }
                    if (id[i][j][1] > 0) {
                        if (id[i][j][0] > 0) {
                            flow.addEdge(id[i][j][0], id[i][j][1], 1);
                        }
                        if (id[i][j + 1][0] > 0) {
                            flow.addEdge(id[i][j + 1][0], id[i][j][1], 1);
                        }
                    }
                }
            }
        }
        System.out.println(cnt - (pv - flow.run(S, T)));
    }
}
