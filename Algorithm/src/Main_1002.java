import java.util.Scanner;

public class Main_1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            double distanse = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            double subtract = r1 > r2 ? r1 - r2 : r2 - r1;
            int result;
            if (distanse == 0 && r1 == r2) result = -1;
            else if (distanse < r1 + r2 && (subtract < distanse)) result = 2;
            else if (distanse == r1 + r2 || distanse == subtract) result = 1;
            else result = 0;
            System.out.println(result);
        }
    }
}