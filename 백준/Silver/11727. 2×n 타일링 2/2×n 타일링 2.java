import java.util.Scanner;

public class Main {

    static int[] DP = new int[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 3;

        System.out.println(f(n));
    }

    static int f(int n) {
        if (DP[n] != 0) return DP[n];

        return DP[n] = (f(n - 1) % 10007 + 2 * f(n - 2) % 10007) % 10007;
    }
}