package 미제출;

import java.util.*;
import java.io.*;

public class Main_14899_수열과_쿼리_19 {
    static int INF = 1000000007;
    static int n, m, stt, en, k;
    static int[] v = new int[2001], inv = new int[2001];
    static int[] par_st = new int[2001], par_en = new int[2001];
    static int[] dist_st = new int[2001], dist_en = new int[2001];
    static List<Edge>[] adj = new List[2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        stt = Integer.parseInt(st.nextToken());
        en = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c));
            adj[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= k; i++) {
            v[i] = Integer.parseInt(st.nextToken());
            inv[v[i]] = i;
        }

        dijkstra(dist_st, stt);
        dijkstra(dist_en, en);
        dfs(par_st, dist_st, v[1], -1, v[1]);
        dfs(par_en, dist_en, v[k], -1, v[k]);

        SegTree tree = new SegTree(2048);
        for (int i = 1; i <= n; i++) {
            for (Edge e : adj[i]) {
                int j = e.to, cost = e.cost;
                if (inv[i] != 0 && inv[j] != 0 && Math.abs(inv[i] - inv[j]) <= 1) continue;
                int t1 = inv[par_st[i]];
                int t2 = inv[par_en[j]];
                tree.update(t1, t2 - 1, dist_st[i] + cost + dist_en[j]);
            }
        }

        for (int i = 1; i < k; i++) {
            int ans = tree.query(i, i);
            System.out.println(ans == INF ? -1 : ans);
        }
    }

    static void dijkstra(int[] dist, int start) {
        Arrays.fill(dist, 1, n + 1, 1 << 30);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, dist[start] = 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int cdist = edge.cost, cur = edge.to;
            if (dist[cur] != cdist) continue;

            for (Edge next : adj[cur]) {
                int nxt = next.to, cost = next.cost;
                if (dist[nxt] > cdist + cost) {
                    pq.add(new Edge(nxt, dist[nxt] = cdist + cost));
                }
            }
        }
    }

    static void dfs(int[] par, int[] dist, int cur, int prv, int t) {
        if (par[cur] != 0) return;
        if (inv[cur] != 0) t = cur;
        par[cur] = t;
        for (Edge next : adj[cur]) {
            int nxt = next.to, cost = next.cost;
            if (nxt == prv || dist[cur] + cost != dist[nxt]) continue;
            if (inv[cur] == 0 && inv[nxt] != 0) continue;
            dfs(par, dist, nxt, cur, t);
        }
    }

    static class Edge implements Comparable<Edge> {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    static class SegTree {
        int[] tree, lazy;
        int size;

        SegTree(int size) {
            this.size = size;
            tree = new int[size << 1];
            lazy = new int[size << 1];
            Arrays.fill(tree, INF);
            Arrays.fill(lazy, INF);
        }

        void push(int node, int L, int R) {
            if (node < size) {
                for (int nxt : new int[]{node << 1, node << 1 | 1}) {
                    lazy[nxt] = Math.min(lazy[nxt], lazy[node]);
                }
            }
            tree[node] = Math.min(tree[node], lazy[node]);
            lazy[node] = INF;
        }

        void update(int l, int r, int val) {
            update(l, r, val, 1, 1, size / 2);
        }

        void update(int l, int r, int val, int node, int L, int R) {
            push(node, L, R);
            if (r < L || R < l) return;
            if (l <= L && R <= r) {
                lazy[node] = Math.min(lazy[node], val);
                push(node, L, R);
                return;
            }
            int mid = (L + R) / 2;
            update(l, r, val, node << 1, L, mid);
            update(l, r, val, node << 1 | 1, mid + 1, R);
            tree[node] = Math.min(tree[node << 1], tree[node << 1 | 1]);
        }

        int query(int l, int r) {
            return query(l, r, 1, 1, size / 2);
        }

        int query(int l, int r, int node, int L, int R) {
            push(node, L, R);
            if (r < L || R < l) return INF;
            if (l <= L && R <= r) return tree[node];
            int mid = (L + R) / 2;
            return Math.min(query(l, r, node << 1, L, mid), query(l, r, node << 1 | 1, mid + 1, R));
        }
    }
}
