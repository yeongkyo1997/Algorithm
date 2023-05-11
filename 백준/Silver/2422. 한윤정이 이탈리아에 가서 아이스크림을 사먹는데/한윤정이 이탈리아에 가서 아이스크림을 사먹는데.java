import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        boolean[][] chk = new boolean[205][205];

        for (int i = 0; i < M; ++i) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            chk[p][q] = chk[q][p] = true;
        }

        int ans = 0;
        for (int i = 1; i <= N; ++i)
            for (int j = i + 1; j <= N; ++j) {
                if (chk[i][j]) continue;
                for (int k = j + 1; k <= N; ++k) {
                    if (chk[i][k] || chk[j][k]) continue;
                    ++ans;
                }
            }
        System.out.println(ans);

        scanner.close();
    }
}