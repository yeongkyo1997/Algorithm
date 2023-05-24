import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1315_RPG {
    static int n;
    static int[][] q = new int[100][3];
    static int[][] dp = new int[1001][1001];
    static boolean[] visited = new boolean[100];

    public static int cal(int a, int b) {
        if (dp[a][b] != -1) return dp[a][b];

        int point = 0;
        dp[a][b] = 0;
        ArrayList<Integer> check = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (q[i][0] <= a || q[i][1] <= b) {
                dp[a][b] += 1;
                if (visited[i]) continue;

                point += q[i][2];
                visited[i] = true;
                check.add(i);
            }
        }

        for (int i = 0; i <= point; i++) {
            dp[a][b] = Math.max(dp[a][b], cal(Math.min(1000, a + i), Math.min(1000, b + (point - i))));
        }

        for (Integer integer : check) {
            visited[integer] = false;
        }

        return dp[a][b];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            q[i][0] = sc.nextInt();
            q[i][1] = sc.nextInt();
            q[i][2] = sc.nextInt();
        }

        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        System.out.println(cal(1, 1));
        sc.close();
    }
}
