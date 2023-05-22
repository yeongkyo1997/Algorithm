import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100000;
    static long[] a = new long[MAX + 1];
    static long[] tree = new long[MAX * 4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        init(1, n, 1);
        
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                long k = Long.parseLong(st.nextToken());
                update(1, n, 1, left, right, k);
            } else if (q == 2) {
                int index = Integer.parseInt(st.nextToken());
                System.out.println(getX(1, n, 1, index, 0));
            }
        }
    }

    public static void init(int start, int end, int node) {
        if (start == end) {
            tree[node] = a[start];
            return;
        }
        tree[node] = 0;
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
    }

    public static void update(int start, int end, int node, int left, int right, long k) {
        if (start > right || end < left) return;
        if (left <= start && end <= right) {
            tree[node] += k;
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, left, right, k);
        update(mid + 1, end, node * 2 + 1, left, right, k);
    }

    public static long getX(int start, int end, int node, int index, long ans) {
        if (index < start || index > end) return 0;
        ans += tree[node];
        if (start == end) return ans;
        int mid = (start + end) / 2;
        return getX(start, mid, node * 2, index, ans) + getX(mid + 1, end, node * 2 + 1, index, ans);
    }
}