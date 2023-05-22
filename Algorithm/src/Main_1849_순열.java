import java.io.*;

public class Main_1849_순열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAX_N = 100000;
    static int n;
    static int[] seg = new int[4 * MAX_N];
    static int[] arr = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            update(i, 1, 1, 1, n);
        }
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(br.readLine());
            int q = query(x + 1, 1, 1, n);
            arr[q] = i;
            update(q, 0, 1, 1, n);
        }
        for (int i = 1; i <= n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.close();
    }

    static int update(int pos, int val, int node, int x, int y) {
        if (y < pos || pos < x) {
            return seg[node];
        }
        if (x == y) {
            return seg[node] = val;
        }
        int mid = (x + y) >>> 1;
        return seg[node] = update(pos, val, node * 2, x, mid) + update(pos, val, node * 2 + 1, mid + 1, y);
    }

    static int query(int val, int node, int x, int y) {
        int mid = (x + y) >>> 1;
        if (x == y) {
            return x;
        }
        if (seg[node * 2] >= val) {
            return query(val, node * 2, x, mid);
        }
        return query(val - seg[node * 2], node * 2 + 1, mid + 1, y);
    }
}
