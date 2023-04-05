import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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