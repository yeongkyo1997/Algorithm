package 미제출;

import java.io.*;
import java.util.*;

class Seg {
    int n;
    ArrayList<Integer>[] segTree;

    int findMax(int index, int left, int right, int targL, int targR) {
        if (targL <= left && right <= targR) return segTree[index].isEmpty() ? -1 : segTree[index].get(segTree[index].size() - 1);
        if (right < targL || targR < left) return -1;
        int mid = (left + right) >> 1;
        return Math.max(findMax(2 * index + 1, left, mid, targL, targR), findMax(2 * index + 2, mid + 1, right, targL, targR));
    }

    void add(int left, int right, int pos, int val, int i) {
        if (left <= pos && pos <= right) {
            segTree[0].add(val);
            if (left < right) {
                int mid = (left + right) >> 1;
                add(1, left, mid, pos, val);
                add(2 * 0 + 2, mid + 1, right, pos, val);
            }
            Collections.sort(segTree[0]);
        }
    }

    void remove(int nth) {
        int idx = -1;
        for (int i = 0; i < (n << 2); i++) {
            idx = Collections.binarySearch(segTree[i], nth);
            if (idx >= 0) segTree[i].remove(idx);
        }
    }

    int getMax(int l, int r) {
        return findMax(0, 1, n, l, r);
    }

    Seg(int in) {
        n = in;
        segTree = new ArrayList[(n << 2) + 1];
        for (int i = 0; i < (n << 2); i++) segTree[i] = new ArrayList<>();
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer tk;

    private static void solve() throws IOException {
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int[] u = new int[m];
        int[] v = new int[m];
        Seg[] seg = new Seg[n + 1];
        for (int i = 1; i <= n; ++i) seg[i] = new Seg(n);

        for (int i = 0; i < m; i++) {
            u[i] = Integer.parseInt(tk.nextToken());
            v[i] = Integer.parseInt(tk.nextToken());
            if (u[i] > v[i]) {
                int temp = u[i];
                u[i] = v[i];
                v[i] = temp;
            }
        }
        for (int i = 1; i <= n; ++i) seg[u[i]].add(1, n, u[i], v[i], val);

        int now = 1;
        while (true) {
            bw.write(now + " ");
            int next = -1;
            for (int j = 1; j <= n; ++j) {
                if (j == now) continue;
                int temp = seg[now].getMax(2, n);
                if (temp != -1) {
                    seg[temp].remove(temp);
                    next = temp;
                }
            }
            if (next == -1) break;
            now = next;
        }
    }

    public static void main(String[] args) throws IOException {
        tk = new StringTokenizer(br.readLine());
        solve();
        bw.flush();
    }
}
