import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] adj = new int[101][101];
        int cnt = 0;

        for (int i = 1; i <= 4; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            for (int y = b; y < d; y++) {
                for (int x = a; x < c; x++) {
                    if (adj[y][x] == 0) {
                        cnt++;
                        adj[y][x] = 1;
                    }
                }
            }
        }
        System.out.println(cnt);

        scanner.close();
    }
}