import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points.add(new Point(x, y));
        }

        double res = 0;
        for (int i = 1; i < n; i++) {
            res += ccw(points.get(0).x, points.get(i - 1).x, points.get(i).x,
                    points.get(0).y, points.get(i - 1).y, points.get(i).y);
        }

        System.out.printf("%.1f", Math.abs(res));
    }

    static double ccw(double x1, double x2, double x3, double y1, double y2, double y3) {
        double res = x1 * y2 + x2 * y3 + x3 * y1;
        res += (-y1 * x2 - y2 * x3 - y3 * x1);
        return res / 2;
    }
}