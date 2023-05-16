import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr;
    static long[] tree;
    static long[] lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[N * 4];
        lazy = new long[N * 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        makeTree(1, N, 1);

        for (int i = 0; i < K + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());

                update(1, N, b, c, d, 1);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                bw.write(getQuery(1, N, b, c, 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static long makeTree(int startIdx, int endIdx, int node) {
        if (startIdx == endIdx) {
            return tree[node] = arr[startIdx];
        }

        int mid = (startIdx + endIdx) / 2;
        return tree[node] = makeTree(startIdx, mid, node * 2) + makeTree(mid + 1, endIdx, node * 2 + 1);
    }

    public static void updateLazy(int startIdx, int endIdx, int node) {
        if (lazy[node] != 0) {
            tree[node] += lazy[node] * (endIdx - startIdx + 1);

            if (startIdx != endIdx) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

    public static long getQuery(int startIdx, int endIdx, int lIdx, int rIdx, int node) {
        updateLazy(startIdx, endIdx, node);

        if (rIdx < startIdx || lIdx > endIdx) {
            return 0;
        }

        if (lIdx <= startIdx && endIdx <= rIdx) {
            return tree[node];
        }

        int mid = (startIdx + endIdx) / 2;
        return getQuery(startIdx, mid, lIdx, rIdx, node * 2) + getQuery(mid + 1, endIdx, lIdx, rIdx, node * 2 + 1);
    }

    public static void update(int startIdx, int endIdx, int lIdx, int rIdx, long up, int node) {
        updateLazy(startIdx, endIdx, node);

        if (rIdx < startIdx || lIdx > endIdx) {
            return;
        }

        if (lIdx <= startIdx && endIdx <= rIdx) {
            tree[node] += up * (endIdx - startIdx + 1);

            if (startIdx != endIdx) {
                lazy[node * 2] += up;
                lazy[node * 2 + 1] += up;
            }

            return;
        }

        int mid = (startIdx + endIdx) / 2;
        update(startIdx, mid, lIdx, rIdx, up, node * 2);
        update(mid + 1, endIdx, lIdx, rIdx, up, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}