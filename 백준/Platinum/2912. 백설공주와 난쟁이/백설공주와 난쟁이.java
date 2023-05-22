import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point> {
    int l, r, idx;

    Point(int l, int r, int idx) {
        this.l = l;
        this.r = r;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point p) {
        int x = this.l / Main.sqrtN;
        int y = p.l / Main.sqrtN;

        if (x == y) return Integer.compare(this.r, p.r);
        else return Integer.compare(x, y);
    }
}

public class Main {
    static int MAX = 300001;
    static int MAXQ = 10001;
    static int N, C, M, sqrtN;

    static Point[] q = new Point[MAXQ];
    static int[] list = new int[MAX], ans = new int[MAXQ], cnt = new int[MAXQ];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            list[i] = sc.nextInt();
        }
        sqrtN = (int) Math.sqrt(N);

        M = sc.nextInt();
        for (int i = 1; i <= M; i++) {
            q[i] = new Point(sc.nextInt(), sc.nextInt(), i);
        }
        Arrays.sort(q, 1, M + 1);

        int l = q[1].l;
        int r = q[1].r;
        for (int i = l; i <= r; i++) {
            cnt[list[i]]++;
        }
        solve(q[1].idx, r - l + 1);

        for (int i = 2; i <= M; i++) {
            int nl = q[i].l;
            int nr = q[i].r;
            int idx = q[i].idx;

            for (int j = l; j < nl; j++) {
                cnt[list[j]]--;
            }
            for (int j = l - 1; j >= nl; j--) {
                cnt[list[j]]++;
            }
            for (int j = r; j > nr; j--) {
                cnt[list[j]]--;
            }
            for (int j = r + 1; j <= nr; j++) {
                cnt[list[j]]++;
            }
            solve(idx, nr - nl + 1);

            l = nl;
            r = nr;
        }

        for (int i = 1; i <= M; i++) {
            if (ans[i] == -1) System.out.println("no");
            else System.out.println("yes " + ans[i]);
        }

        sc.close();
    }

    static void solve(int idx, int k) {
        for (int i = 1; i <= C; i++) {
            if (cnt[i] > k / 2) {
                ans[idx] = i;
                return;
            }
        }
        ans[idx] = -1;
    }
}