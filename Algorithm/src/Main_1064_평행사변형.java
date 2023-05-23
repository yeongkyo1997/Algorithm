import java.util.Scanner;
import java.awt.geom.Point2D;

public class Main_1064_평행사변형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double xA = sc.nextDouble();
        double yA = sc.nextDouble();
        double xB = sc.nextDouble();
        double yB = sc.nextDouble();
        double xC = sc.nextDouble();
        double yC = sc.nextDouble();

        Point2D A = new Point2D.Double(xA, yA);
        Point2D B = new Point2D.Double(xB, yB);
        Point2D C = new Point2D.Double(xC, yC);

        Point2D D1 = new Point2D.Double(xB + xC - xA, yB + yC - yA);
        Point2D D2 = new Point2D.Double(xA + xC - xB, yA + yC - yB);
        Point2D D3 = new Point2D.Double(xA + xB - xC, yA + yB - yC);

        double ab = A.distance(B);
        double bc = B.distance(C);
        double ac = A.distance(C);

        double perimeter1 = ab + bc + B.distance(D1) + A.distance(D1);
        double perimeter2 = ab + ac + A.distance(D2) + C.distance(D2);
        double perimeter3 = ac + bc + C.distance(D3) + B.distance(D3);

        double maxPerimeter = Math.max(perimeter1, Math.max(perimeter2, perimeter3));
        double minPerimeter = Math.min(perimeter1, Math.min(perimeter2, perimeter3));

        if (maxPerimeter != 0) {
            System.out.printf("%.9f%n", maxPerimeter - minPerimeter);
        } else {
            System.out.println(-1);
        }
    }
}
