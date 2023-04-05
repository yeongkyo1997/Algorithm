import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_2162_선분_그룹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static int[] r;
    static int[] cnt;
    static int[][] L;

    static int getParent(int a) {
        if (r[a] == a) return a;
        else return r[a] = getParent(r[a]);
    }

    static void join(int a, int b) {
        r[getParent(a)] = getParent(b);
    }

    static long ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        long ret = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if (ret < 0) return -1;
        else if (ret > 0) return 1;
        else return 0;
    }

    static boolean isCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {


        if (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) <= 0 && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) <= 0) {

            if ((x1 > x3 && x1 > x4 && x2 > x3 && x2 > x4) || (x3 > x1 && x3 > x2 && x4 > x1 && x4 > x2)) return false;
            else if ((y1 > y3 && y1 > y4 && y2 > y3 && y2 > y4) || (y3 > y1 && y3 > y2 && y4 > y1 && y4 > y2))
                return false;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        r = new int[n + 1];
        cnt = new int[n + 1];
        L = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            L[i][0] = Integer.parseInt(st.nextToken());
            L[i][1] = Integer.parseInt(st.nextToken());
            L[i][2] = Integer.parseInt(st.nextToken());
            L[i][3] = Integer.parseInt(st.nextToken());
        }

        IntStream.rangeClosed(1, n).forEach(i -> r[i] = i);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++)
                if (isCross(L[i][0], L[i][1], L[i][2], L[i][3], L[j][0], L[j][1], L[j][2], L[j][3])) join(i, j);
        }

        IntStream.rangeClosed(1, n).forEach(i -> cnt[getParent(i)]++);

        int groupCnt = 0, maxCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] > 0) groupCnt++;
            if (cnt[i] > maxCnt) maxCnt = cnt[i];
        }

        bw.write(groupCnt + "\n" + maxCnt);
        bw.close();
    }
}
