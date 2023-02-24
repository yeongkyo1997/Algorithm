import java.io.*;
import java.util.StringTokenizer;

public class Solution_1247 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static Point company;
    private static Point home;
    private static Point[] list;
    static Point[] tmp;
    private static int N;
    static int result = Integer.MAX_VALUE;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list = new Point[N];
            tmp = new Point[N];
            for (int i = 0; i < N; i++) {
                list[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            permGetMinVal(0, 0, 0);
            bw.write("#" + (t + 1) + " " + result + "\n");
        }
        bw.close();
    }

    static int getDist(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static void permGetMinVal(int depth, int flag, int sum) {
        if (depth == N) {
            sum += getDist(tmp[N - 1], home);
            result = Math.min(result, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;
            tmp[depth] = list[i];
            if (depth == 0) permGetMinVal(depth + 1, flag | 1 << i, sum + getDist(company, tmp[depth]));
            else permGetMinVal(depth + 1, flag | 1 << i, sum + getDist(tmp[depth], tmp[depth - 1]));
        }
    }
}
