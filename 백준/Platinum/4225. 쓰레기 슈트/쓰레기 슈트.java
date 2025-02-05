import java.io.*;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point> {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point o) {
            if (Math.abs(this.x - o.x) > 1e-9)
                return this.x < o.x ? -1 : 1;
            if (Math.abs(this.y - o.y) > 1e-9)
                return this.y < o.y ? -1 : 1;
            return 0;
        }
    }

    static double cross(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    static double distance(Point a, Point b) {
        double dx = a.x - b.x, dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static ArrayList<Point> convexHull(Point[] pts) {
        int n = pts.length;
        Arrays.sort(pts);
        ArrayList<Point> lower = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (lower.size() >= 2 && cross(lower.get(lower.size() - 2), lower.get(lower.size() - 1), pts[i]) <= 0)
                lower.remove(lower.size() - 1);
            lower.add(pts[i]);
        }
        ArrayList<Point> upper = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (upper.size() >= 2 && cross(upper.get(upper.size() - 2), upper.get(upper.size() - 1), pts[i]) <= 0)
                upper.remove(upper.size() - 1);
            upper.add(pts[i]);
        }

        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        ArrayList<Point> hull = new ArrayList<>();
        hull.addAll(lower);
        hull.addAll(upper);
        return hull;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNo = 1;
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;
            line = line.trim();
            if (line.equals(""))
                continue;
            int n = Integer.parseInt(line);
            if (n == 0)
                break;
            Point[] pts = new Point[n];
            for (int i = 0; i < n; i++) {
                String[] parts = br.readLine().trim().split("\\s+");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                pts[i] = new Point(x, y);
            }

            ArrayList<Point> hull = convexHull(pts);
            int m = hull.size();
            double minWidth = Double.MAX_VALUE;

            if (m < 3)
                minWidth = 0.0;
            else {
                int j = 1;

                for (int i = 0; i < m; i++) {
                    int nxt = (i + 1) % m;

                    while (true) {
                        int nextJ = (j + 1) % m;
                        double areaCurrent = Math.abs(cross(hull.get(i), hull.get(nxt), hull.get(j)));
                        double areaNext = Math.abs(cross(hull.get(i), hull.get(nxt), hull.get(nextJ)));
                        if (areaNext > areaCurrent + 1e-9)
                            j = nextJ;
                        else
                            break;
                    }
                    double edgeLength = distance(hull.get(i), hull.get(nxt));
                    double widthCandidate = Math.abs(cross(hull.get(i), hull.get(nxt), hull.get(j))) / edgeLength;
                    minWidth = Math.min(minWidth, widthCandidate);
                }
            }

            double ans = Math.ceil(minWidth * 100.0 - 1e-9) / 100.0;
            bw.write("Case " + caseNo + ": " + String.format("%.2f", ans) + "\n");
            caseNo++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}