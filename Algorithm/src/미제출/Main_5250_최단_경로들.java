package 미제출;

import java.util.*;
import java.lang.Math;

public class Main_5250_최단_경로들 {
    static final long inf = (long) 1e18;

    static class Node {
        long mn, mx, sum;

        Node() {
        }

        Node(long mn, long mx, long sum) {
            this.mn = mn;
            this.mx = mx;
            this.sum = sum;
        }
    }

    static Node[] tree = new Node[1 << 18];
    static long[] tmp1 = new long[1 << 18];
    static long[] tmp2 = new long[1 << 18];

    static Node merge(Node a, Node b) {
        return new Node(Math.min(a.mn, b.mn), Math.max(a.mx, b.mx), a.sum + b.sum);
    }

    static void push(int node, int s, int e) {
        if (tmp2[node] <= -inf) {
            tree[node].mx += tmp1[node];
            tree[node].mn += tmp1[node];
            tree[node].sum += (e - s + 1) * tmp1[node];
            if (s != e) {
                tmp1[node * 2] += tmp1[node];
                tmp1[node * 2 + 1] += tmp1[node];
            }
        } else {
            tree[node].mx = tree[node].mn = tmp1[node] + tmp2[node];
            tree[node].sum = (e - s + 1) * (tmp1[node] + tmp2[node]);
            if (s != e) {
                tmp1[node * 2] = tmp1[node];
                tmp1[node * 2 + 1] = tmp1[node];
                tmp2[node * 2] = tmp2[node];
                tmp2[node * 2 + 1] = tmp2[node];
            }
        }
        tmp1[node] = 0;
        tmp2[node] = -inf;
    }

    static void add(int node, int s, int e, int l, int r, long v) {
        push(node, s, e);
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            tmp1[node] = v;
            push(node, s, e);
            return;
        }
        int m = (s + e) >> 1;
        add(node * 2, s, m, l, r, v);
        add(node * 2 + 1, m + 1, e, l, r, v);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static void div(int node, int s, int e, int l, int r, long d) {
        push(node, s, e);
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            if (Math.floor((double) tree[node].mn / d) == Math.floor((double) tree[node].mx / d)) {
                tmp2[node] = (long) Math.floor((double) tree[node].mn / d);
                push(node, s, e);
                return;
            }
            if (tree[node].mn + 1 == tree[node].mx) {
                tmp1[node] = (long) (Math.floor((double) tree[node].mn / d) - tree[node].mn);
                push(node, s, e);
                return;
            }
        }
        int m = (s + e) >> 1;
        div(node * 2, s, m, l, r, d);
        div(node * 2 + 1, m + 1, e, l, r, d);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static Node query(int node, int s, int e, int l, int r) {
        push(node, s, e);
        if (r < s || e < l) return new Node(inf, -inf, 0);
        if (l <= s && e <= r) return tree[node];
        int m = (s + e) >> 1;
        return merge(query(node * 2, s, m, l, r), query(node * 2 + 1, m + 1, e, l, r));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(tmp2, -inf);

        for (int i = 0; i < (1 << 18); i++) {
            tree[i] = new Node();
        }

        int n = sc.nextInt();
        int q = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long t = sc.nextLong();
            add(1, 0, n - 1, i, i, t);
        }
        while (q-- > 0) {
            int op = sc.nextInt();
            if (op == 1) {
                long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong();
                add(1, 0, n - 1, (int) a, (int) b, c);
            } else if (op == 2) {
                long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong();
                div(1, 0, n - 1, (int) a, (int) b, c);
            } else {
                int a = sc.nextInt(), b = sc.nextInt();
                Node now = query(1, 0, n - 1, a, b);
                if (op == 3) System.out.println(now.mn);
                else System.out.println(now.sum);
            }
        }
        sc.close();
    }
}
