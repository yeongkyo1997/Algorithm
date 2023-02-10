import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1002 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Point {
        double x, y, r;

        public Point(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Point p1, p2;
            st = new StringTokenizer(br.readLine());
            double x, y, r;
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            r = Double.parseDouble(st.nextToken());
            p1 = new Point(x, y, r);

            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            r = Double.parseDouble(st.nextToken());
            p2 = new Point(x, y, r);
        }
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y), 2));
    }
}
