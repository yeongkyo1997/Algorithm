import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static long[] arr;
    static long[] tree;

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void update(int idx, long val, int node, int start, int end) {
        if (idx < start || end < idx)
            return;

        if (start == end) {
            tree[node] = val;
            return;
        }

        int mid = (start + end) / 2;

        update(idx, val, node * 2, start, mid);
        update(idx, val, node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int left, int right, int node, int start, int end) {
        if (right < start || end < left)
            return 0;

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return query(left, right, node * 2, start, mid) + query(left, right, node * 2 + 1, mid + 1, end);
    }

    static public void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new long[4 * N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        build(1, 0, N - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                update(b - 1, c, 1, 0, N - 1);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                bw.write(query(b - 1, c - 1, 1, 0, N - 1) + "\n");
            }
        }
        bw.close();
    }
}