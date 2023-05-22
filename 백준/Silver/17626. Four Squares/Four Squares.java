import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int tmp = i - j * j;
                minn = Math.min(minn, dp[tmp]);
            }
            dp[i] = minn + 1;
        }
        
        System.out.println(dp[n]);
    }
}
