import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Edge>[] tree;
    static int[] parent, depth, heavy, head, pos;
    static int currentPos;
    static int[] base;
    static int[] edgeToNode;

    static class Edge {
        int to, cost, id;

        Edge(int to, int cost, int id) {
            this.to = to;
            this.cost = cost;
            this.id = id;
        }
    }

    static class InputEdge {
        int u, v, w;

        InputEdge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static int dfs(int u, int p) {
        parent[u] = p;
        depth[u] = (p == -1 ? 0 : depth[p] + 1);
        int size = 1;
        int maxSubtree = 0;
        heavy[u] = -1;
        for (Edge edge : tree[u]) {
            int v = edge.to;
            if (v == p)
                continue;
            int subSize = dfs(v, u);
            if (subSize > maxSubtree) {
                maxSubtree = subSize;
                heavy[u] = v;
            }
            size += subSize;
        }
        return size;
    }

    public static void decompose(int u, int h) {
        head[u] = h;
        pos[u] = currentPos++;

        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }

        for (Edge edge : tree[u]) {
            int v = edge.to;
            if (v == parent[u] || v == heavy[u])
                continue;
            decompose(v, v);
        }
    }

    static int[] segtree;
    static int segtree_n;

    public static void segtree_build(int n) {
        segtree_n = 1;
        while (segtree_n < n)
            segtree_n *= 2;
        segtree = new int[segtree_n * 2];
        for (int i = 0; i < n; i++) {
            segtree[segtree_n + i] = base[i];
        }
        for (int i = n; i < segtree_n; i++) {
            segtree[segtree_n + i] = 0;
        }
        for (int i = segtree_n - 1; i > 0; i--) {
            segtree[i] = Math.max(segtree[i * 2], segtree[i * 2 + 1]);
        }
    }

    public static void segtree_update(int idx, int value) {
        int posIdx = segtree_n + idx;
        segtree[posIdx] = value;
        for (posIdx /= 2; posIdx > 0; posIdx /= 2) {
            segtree[posIdx] = Math.max(segtree[posIdx * 2], segtree[posIdx * 2 + 1]);
        }
    }

    public static int segtree_query(int l, int r) {
        int res = 0;
        l += segtree_n;
        r += segtree_n;
        while (l <= r) {
            if (l % 2 == 1) {
                res = Math.max(res, segtree[l]);
                l++;
            }
            if (r % 2 == 0) {
                res = Math.max(res, segtree[r]);
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return res;
    }

    public static int queryPath(int u, int v) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }
            res = Math.max(res, segtree_query(pos[head[u]], pos[u]));
            u = parent[head[u]];
        }
        if (u == v)
            return res;
        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        res = Math.max(res, segtree_query(pos[u] + 1, pos[v]));
        return res;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        InputEdge[] inputEdges = new InputEdge[N];

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            inputEdges[i] = new InputEdge(u, v, w);
            tree[u].add(new Edge(v, w, i));
            tree[v].add(new Edge(u, w, i));
        }

        parent = new int[N + 1];
        depth = new int[N + 1];
        heavy = new int[N + 1];
        head = new int[N + 1];
        pos = new int[N + 1];
        currentPos = 0;

        dfs(1, -1);
        decompose(1, 1);

        base = new int[N];
        edgeToNode = new int[N];
        for (int i = 1; i <= N - 1; i++) {
            InputEdge ie = inputEdges[i];
            int u = ie.u, v = ie.v, w = ie.w;

            if (depth[u] > depth[v]) {
                edgeToNode[i] = u;
                base[pos[u]] = w;
            } else {
                edgeToNode[i] = v;
                base[pos[v]] = w;
            }
        }
        base[pos[1]] = 0;

        segtree_build(N);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {

                int edgeId = Integer.parseInt(st.nextToken());
                int newCost = Integer.parseInt(st.nextToken());
                int node = edgeToNode[edgeId];
                segtree_update(pos[node], newCost);
            } else if (type == 2) {

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int answer = queryPath(u, v);
                bw.write(answer + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}