import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, q, a, b, c;

    static int[] data;
    static long[] tree;

    static long init(int idx, int start, int end) {
        if (start == end) return tree[idx] = data[start];
        int mid = (start + end) >> 1;
        return tree[idx] = init(idx << 1, start, mid) + init((idx << 1) + 1, mid + 1, end);
    }

    static long sum(int start, int end, int idx, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[idx];
        int mid = (start + end) >> 1;
        return sum(start, mid, idx << 1, left, right) + sum(mid + 1, end, (idx << 1) + 1, left, right);
    }

    static long update(int start, int end, int node, int idx, long tmp) {
        if (idx < start || idx > end) return tree[node];
        if (start == end) return tree[node] = tmp;
        int mid = (start + end) >> 1;
        return tree[node] = update(start, mid, node << 1, idx, tmp) + update(mid + 1, end, (node << 1) + 1, idx, tmp);
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        data = new int[n + 1];
        tree = new long[n * 4];

        init(1, 1, n);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            int max = Math.max(b, c);
            int min = Math.min(b, c);

            if (a == 0) bw.write(sum(1, n, 1, min, max) + "\n");
            else update(1, n, 1, b, c);
        }
        bw.flush();
        bw.close();
    }
}