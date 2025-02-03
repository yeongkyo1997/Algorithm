
import java.io.*;
import java.util.*;
 
public class Main {
    static final int INF = 1000000000;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        EdgeInput[] edges = new EdgeInput[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new EdgeInput(u, v, w, i);
        }
 
        // --- Compute MST using Kruskal's algorithm ---
        DSU dsu = new DSU(n);
        Arrays.sort(edges, new Comparator<EdgeInput>() {
            public int compare(EdgeInput a, EdgeInput b) {
                return Integer.compare(a.w, b.w);
            }
        });
 
        long MSTcost = 0;
        int cnt = 0;
        boolean[] inMST = new boolean[m];
        for (EdgeInput e : edges) {
            if (dsu.find(e.u) != dsu.find(e.v)) {
                dsu.union(e.u, e.v);
                MSTcost += e.w;
                inMST[e.idx] = true;
                cnt++;
            }
        }
 
        // If the graph is not connected, no spanning tree exists.
        if (cnt < n - 1) {
            for (int i = 0; i < m; i++) {
                bw.write("-1\n");
            }
            bw.flush();
            return;
        }
 
        // --- Build the MST tree T ---
        ArrayList<Edge>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            if (inMST[edges[i].idx]) {
                int u = edges[i].u, v = edges[i].v, w = edges[i].w, idx = edges[i].idx;
                tree[u].add(new Edge(v, w, idx));
                tree[v].add(new Edge(u, w, idx));
            }
        }
 
        // --- Heavy-Light Decomposition preparation ---
        int[] parent = new int[n];
        int[] depth = new int[n];
        int[] heavy = new int[n];
        int[] size = new int[n];
        int[] head = new int[n];
        int[] pos = new int[n];
        // For each node (except the root) record the MST edge (its weight and original index)
        int[] edgeWeight = new int[n];
        int[] edgeIdx = new int[n];
        Arrays.fill(heavy, -1);
 
        dfs(0, -1, tree, parent, depth, heavy, size, edgeWeight, edgeIdx);
        int[] curPos = new int[]{0};
        decompose(0, 0, tree, parent, heavy, head, pos, curPos);
 
        // --- Build segment tree over the heavy-light array ---
        SegmentTree segTree = new SegmentTree(n);
 
        // --- Process every non-MST edge ---
        // For each non-MST edge, update the candidate value (its weight) along the unique path in the MST.
        for (int i = 0; i < m; i++) {
            if (!inMST[edges[i].idx]) {
                int u = edges[i].u;
                int v = edges[i].v;
                int w = edges[i].w;
                int l = lca(u, v, head, pos, parent, depth);
                // Update from u to LCA (excluding LCA)
                updatePath(u, l, w, head, pos, parent, segTree);
                // Update from v to LCA (excluding LCA)
                updatePath(v, l, w, head, pos, parent, segTree);
            }
        }
 
        // --- Compute answers ---
        // For a non-MST edge, the MST remains valid so answer = MSTcost.
        long[] ans = new long[m];
        for (int i = 0; i < m; i++) {
            if (!inMST[i]) {
                ans[i] = MSTcost;
            }
        }
        // For each MST edge (represented by a node u != root),
        // get its candidate value from the segment tree.
        for (int u = 1; u < n; u++) {
            int candidate = segTree.query(pos[u]);
            int w = edgeWeight[u];
            int origIdx = edgeIdx[u];
            if (candidate == segTree.INF) {
                ans[origIdx] = -1;
            } else {
                ans[origIdx] = MSTcost - w + candidate;
            }
        }
 
        // --- Output the answers in the original edge order ---
        for (int i = 0; i < m; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
    }
 
    // DFS to compute parent, depth, subtree sizes, and the heavy child.
    static void dfs(int u, int p, ArrayList<Edge>[] tree, int[] parent, int[] depth, int[] heavy, int[] size, int[] edgeWeight, int[] edgeIdx) {
        parent[u] = p;
        size[u] = 1;
        for (Edge e : tree[u]) {
            int v = e.to;
            if (v == p) continue;
            depth[v] = depth[u] + 1;
            edgeWeight[v] = e.w;
            edgeIdx[v] = e.idx;
            dfs(v, u, tree, parent, depth, heavy, size, edgeWeight, edgeIdx);
            if (heavy[u] == -1 || size[v] > size[heavy[u]]) {
                heavy[u] = v;
            }
            size[u] += size[v];
        }
    }
 
    // Heavy-Light Decomposition: assign chain heads and positions.
    static void decompose(int u, int h, ArrayList<Edge>[] tree, int[] parent, int[] heavy, int[] head, int[] pos, int[] curPos) {
        head[u] = h;
        pos[u] = curPos[0]++;
        if (heavy[u] != -1) {
            decompose(heavy[u], h, tree, parent, heavy, head, pos, curPos);
        }
        for (Edge e : tree[u]) {
            int v = e.to;
            if (v == parent[u] || v == heavy[u]) continue;
            decompose(v, v, tree, parent, heavy, head, pos, curPos);
        }
    }
 
    // Compute LCA using the heavy-light decomposition arrays.
    static int lca(int u, int v, int[] head, int[] pos, int[] parent, int[] depth) {
        while (head[u] != head[v]) {
            if (depth[head[u]] > depth[head[v]])
                u = parent[head[u]];
            else
                v = parent[head[v]];
        }
        return depth[u] < depth[v] ? u : v;
    }
 
    // Update the path from node u to its ancestor 'anc' (excluding anc) in the segment tree.
    static void updatePath(int u, int anc, int val, int[] head, int[] pos, int[] parent, SegmentTree segTree) {
        while (head[u] != head[anc]) {
            segTree.update(pos[head[u]], pos[u], val);
            u = parent[head[u]];
        }
        if (u != anc) {
            segTree.update(pos[anc] + 1, pos[u], val);
        }
    }
 
    // DSU for Kruskal's algorithm.
    static class DSU {
        int[] par;
 
        DSU(int n) {
            par = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
        }
 
        int find(int a) {
            return par[a] == a ? a : (par[a] = find(par[a]));
        }
 
        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b)
                par[b] = a;
        }
    }
 
    // Edge class for the original edges.
    static class EdgeInput {
        int u, v, w, idx;
 
        EdgeInput(int u, int v, int w, int idx) {
            this.u = u;
            this.v = v;
            this.w = w;
            this.idx = idx;
        }
    }
 
    // Edge class for MST tree edges.
    static class Edge {
        int to, w, idx;
 
        Edge(int to, int w, int idx) {
            this.to = to;
            this.w = w;
            this.idx = idx;
        }
    }
 
    // Segment Tree that supports range "chmin" updates.
    static class SegmentTree {
        int n;
        int[] segMin, segMax, lazy;
        final int INF = 1000000000;
 
        SegmentTree(int n) {
            this.n = n;
            segMin = new int[4 * n];
            segMax = new int[4 * n];
            lazy = new int[4 * n];
            Arrays.fill(lazy, INF);
            build(1, 0, n - 1);
        }
 
        void build(int idx, int l, int r) {
            if(l == r) {
                segMin[idx] = INF;
                segMax[idx] = INF;
                return;
            }
            int mid = (l + r) >> 1;
            build(idx * 2, l, mid);
            build(idx * 2 + 1, mid + 1, r);
            segMin[idx] = Math.min(segMin[idx * 2], segMin[idx * 2 + 1]);
            segMax[idx] = Math.max(segMax[idx * 2], segMax[idx * 2 + 1]);
        }
 
        void pushDown(int idx, int l, int r) {
            if(lazy[idx] != INF) {
                int mid = (l + r) >> 1;
                int left = idx * 2, right = idx * 2 + 1;
                lazy[left] = lazy[idx];
                segMin[left] = lazy[idx];
                segMax[left] = lazy[idx];
                lazy[right] = lazy[idx];
                segMin[right] = lazy[idx];
                segMax[right] = lazy[idx];
                lazy[idx] = INF;
            }
        }
 
        // Update range [ql, qr] with: A[i] = min(A[i], val)
        void update(int ql, int qr, int val) {
            update(1, 0, n - 1, ql, qr, val);
        }
 
        void update(int idx, int l, int r, int ql, int qr, int val) {
            if(qr < l || ql > r) return;
            if(ql <= l && r <= qr) {
                if(segMax[idx] <= val) return; // nothing to do
                if(segMin[idx] >= val) {
                    segMin[idx] = val;
                    segMax[idx] = val;
                    lazy[idx] = val;
                    return;
                }
            }
            pushDown(idx, l, r);
            int mid = (l + r) >> 1;
            update(idx * 2, l, mid, ql, qr, val);
            update(idx * 2 + 1, mid + 1, r, ql, qr, val);
            segMin[idx] = Math.min(segMin[idx * 2], segMin[idx * 2 + 1]);
            segMax[idx] = Math.max(segMax[idx * 2], segMax[idx * 2 + 1]);
        }
 
        // Query the value at position posQuery.
        int query(int posQuery) {
            return query(1, 0, n - 1, posQuery);
        }
 
        int query(int idx, int l, int r, int posQuery) {
            if(l == r) return segMin[idx];
            pushDown(idx, l, r);
            int mid = (l + r) >> 1;
            if(posQuery <= mid) return query(idx * 2, l, mid, posQuery);
            else return query(idx * 2 + 1, mid + 1, r, posQuery);
        }
    }
}
