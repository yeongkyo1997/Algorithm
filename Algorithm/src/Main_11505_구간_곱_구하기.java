import java.io.*;
import java.util.StringTokenizer;

public class Main_11505_구간_곱_구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;
    static long[] tree;

    static final int MOD = 1000000007;

    static class SegmentTree {
        long init(int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];
            int mid = (start + end) / 2;
            return tree[node] = (init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end)) % MOD;
        }

        long query(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 1;
            if (left <= start && end <= right) return tree[node];
            int mid = (start + end) / 2;
            return (query(node * 2, start, mid, left, right) * query(node * 2 + 1, mid + 1, end, left, right)) % MOD;
        }

        long update(int node, int start, int end, int idx, int val) {
            if (idx < start || idx > end) return tree[node];
            if (start == end) return tree[node] = val;
            int mid = (start + end) / 2;
            return tree[node] = (update(node * 2, start, mid, idx, val) * update(node * 2 + 1, mid + 1, end, idx, val)) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        tree = new long[N * 4];
        SegmentTree segmentTree = new SegmentTree();
        segmentTree.init(1, 0, N - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) segmentTree.update(1, 0, N - 1, b - 1, c);
            else bw.write(segmentTree.query(1, 0, N - 1, b - 1, c - 1) + "\n");
        }
        bw.close();
    }
}
