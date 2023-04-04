import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1087_쥐_잡기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static Pos[] p = new Pos[55];
    static Pos[] v = new Pos[55];
    static int n;

    static class Pos {
        double x, y;

        public Pos(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static double solve(double t) {
        Pos low = new Pos(p[0].x + t * v[0].x, p[0].y + t * v[0].y);
        Pos high = new Pos(p[0].x + t * v[0].x, p[0].y + t * v[0].y);
        for (int i = 1; i < n; i++) {
            low.x = Math.min(low.x, p[i].x + t * v[i].x);
            low.y = Math.min(low.y, p[i].y + t * v[i].y);
            high.x = Math.max(high.x, p[i].x + t * v[i].x);
            high.y = Math.max(high.y, p[i].y + t * v[i].y);
        }
        double x, y;
        x = high.x - low.x;
        y = high.y - low.y;
        return Math.max(x, y);
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            v[i] = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }
        double low = 0;
        double high = 2000;
        for (int i = 0; i < 100 && low < high; i++) {
            double a = (low * 2 + high) / 3;
            double b = (low + 2 * high) / 3;
            if (solve(a) < solve(b)) {
                high = b;
            } else {
                low = a;
            }
        }
        bw.write(String.format("%.11f\n", solve(low)));
        bw.close();
    }
}


