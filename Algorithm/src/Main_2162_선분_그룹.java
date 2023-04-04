//import sys
//
//sys.setrecursionlimit(10 ** 8)  # pypy 제출시 삭제!
//        input = lambda: sys.stdin.readline().rstrip()
//        # in_range = lambda y,x: 0<=y<n and 0<=x<m
//
//
//def find(v):
//        if v == root[v]:
//        return v
//        root[v] = find(root[v])
//        return root[v]
//
//
//        def union(v1, v2):
//        r1 = find(v1)
//        r2 = find(v2)
//        if r1 > r2:
//        r1, r2 = r2, r1  # r1<=r2 되게끔
//        root[r2] = r1
//
//
//        def cross(line1, line2):
//
//        a = (line1[0], line1[1])  # line 1
//        b = (line1[2], line1[3])  # line 1
//        c = (line2[0], line2[1])  # line 2
//        d = (line2[2], line2[3])  # line 2
//        if a > b:
//        a, b = b, a
//        if c > d:
//        c, d = d, c
//
//        ab = (b[0] - a[0], b[1] - a[1])  # a -> b
//        ac = (c[0] - a[0], c[1] - a[1])  # a -> c
//        ad = (d[2] - a[0], d[3] - a[1])  # a -> d
//
//        # 벡터로 삼각형 넓이 구하기
//        # 2S = ab_x * ac_y - ab_y * ac_x
//        t1 = ab[0] * ac[1] - ab[1] * ac[0]  # 선분ab 와 점c로 만든 삼각형 넓이
//        t2 = ab[0] * ad[1] - ab[1] * ad[0]  # 선분ab 와 점d로 만든 삼각형 넓이
//
//        if t1 * t2 <= 0:
//        if t1 == 0 and t2 == 0:  # 한 직선 위에 네 점 있을 때
//        return a <= c <= b or a <= d <= b or c <= a <= d or c <= b <= d
//        return 1
//        else:
//        return 0
//
//
//        n = int(input())
//        lines = [0 for _ in range(n)]
//        for i in range(n):
//        x1, y1, x2, y2 = map(int, input().split())
//        lines[i] = (x1, y1, x2, y2)
//
//        root = [i for i in range(n)]
//
//
//        for i in range(n - 1):
//        for j in range(i + 1, n):
//        if cross(lines[i], lines[j]) and cross(lines[j], lines[i]):
//        if find(i) != find(j):
//        union(i, j)
//
//
//        for i in range(n):
//        find(i)
//
//        print(len(set(root)))
//
//        root.sort()
//        cnt = 1
//        max_cnt = 1
//        for i in range(1, n):
//        cnt = cnt + 1 if root[i - 1] == root[i] else 1
//        max_cnt = max(max_cnt, cnt)
//        print(max_cnt)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//py3 to java
public class Main_2162_선분_그룹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[] parent;
    static int[][] lines;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        lines = new int[n][4];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
            lines[i][2] = Integer.parseInt(st.nextToken());
            lines[i][3] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cross(lines[i], lines[j]) && cross(lines[j], lines[i])) {
                    if (find(i) != find(j)) {
                        union(i, j);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++)
            find(i);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");

        int max_cnt = 0;
        for (int i = 0; i < n; i++) {
            int cnt2 = 0;
            for (int j = 0; j < n; j++) {
                if (parent[i] == parent[j]) {
                    cnt2++;
                }
            }
            max_cnt = Math.max(max_cnt, cnt2);
        }
        bw.write(max_cnt + "\n");
        bw.close();
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        parent[b] = a;
    }

    static boolean cross(int[] line1, int[] line2) {
        int[] a = {line1[0], line1[1]};
        int[] b = {line1[2], line1[3]};
        int[] c = {line2[0], line2[1]};
        int[] d = {line2[2], line2[3]};

        if (a[0] > b[0]) {
            int[] tmp = a;
            a = b;
            b = tmp;
        }

        if (c[0] > d[0]) {
            int[] tmp = c;
            c = d;
            d = tmp;
        }
        int[] ab = {b[0] - a[0], b[1] - a[1]};
        int[] ac = {c[0] - a[0], c[1] - a[1]};
        int[] ad = {d[0] - a[0], d[1] - a[1]};
        int t1 = ab[0] * ac[1] - ab[1] * ac[0];
        int t2 = ab[0] * ad[1] - ab[1] * ad[0];

        if (t1 * t2 <= 0) {
            if (t1 == 0 && t2 == 0) {
                return a[0] <= c[0] && c[0] <= b[0] || a[0] <= d[0] && d[0] <= b[0] || c[0] <= a[0] && a[0] <= d[0];
            }
            return true;
        }
        return false;
    }
}