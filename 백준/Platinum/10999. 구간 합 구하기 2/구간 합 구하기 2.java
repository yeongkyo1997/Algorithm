import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M, K;
    static long[] data;
    static long[] tree;
    static long[] lazy;

    static long init(int node, int start, int end) {
        if (start == end) return tree[node] = data[start];

        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    static void updateLazy(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += lazy[node] * (end - start + 1);

            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static long lazy(int node, int start, int end, int left, int right, long add) {
        updateLazy(node, start, end);

        if (right < start || end < left) return tree[node];
        else if (left <= start && end <= right) {
            tree[node] += add * (end - start + 1);

            if (start != end) {
                lazy[node * 2] += add;
                lazy[node * 2 + 1] += add;
            }

            return tree[node];
        }

        int mid = (start + end) / 2;
        return tree[node] = lazy(node * 2, start, mid, left, right, add) + lazy(node * 2 + 1, mid + 1, end, left, right, add);
    }

    static long sum(int node, int start, int end, int left, int right) {
        updateLazy(node, start, end);

        if (right < start || end < left) return 0;
        else if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new long[N];
        for (int i = 0; i < N; i++) {
            data[i] = Long.parseLong(br.readLine());
        }

        int height = (int) Math.ceil(Math.log(N) / Math.log(2));
        tree = new long[1 << (height + 1)];
        lazy = new long[1 << (height + 1)];

        init(1, 0, N - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a--;
            b--;

            if (cmd == 1) {
                long add = Long.parseLong(st.nextToken());
                lazy(1, 0, N - 1, a, b, add);
            } else {
                bw.write(sum(1, 0, N - 1, a, b) + "\n");
            }
        }

        bw.close();
    }
}