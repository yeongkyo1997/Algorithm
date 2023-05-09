import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int J = sc.nextInt();
        int[] apples = new int[J];

        for (int i = 0; i < J; i++) {
            apples[i] = sc.nextInt();
        }

        System.out.println(minimumBasketMoves(N, M, apples));
    }

    public static int minimumBasketMoves(int N, int M, int[] apples) {
        int basketLeft = 1;
        int basketRight = M;
        int moveCount = 0;

        for (int apple : apples) {
            if (apple < basketLeft) {
                moveCount += basketLeft - apple;
                basketRight -= (basketLeft - apple);
                basketLeft = apple;
            } else if (apple > basketRight) {
                moveCount += apple - basketRight;
                basketLeft += (apple - basketRight);
                basketRight = apple;
            }
        }

        return moveCount;
    }
}
