import java.util.BitSet;

import static java.util.stream.IntStream.rangeClosed;

public class Main_18439 {
    public static int findLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        BitSet[] dp = new BitSet[m + 1];
        rangeClosed(0, m).forEach(i -> dp[i] = new BitSet(n + 1));

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i].set(j);
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i].set(j, dp[i - 1].get(j - 1));
                else dp[i].set(j, dp[i - 1].get(j) || dp[i].get(j - 1));
            }
        }
        int lcsLength = 0;
        for (int i = n; i >= 0; i--) {
            if (!dp[m].get(i)) continue;
            lcsLength = i;
            break;
        }
        return lcsLength;
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int lcsLength = findLCS(s1, s2);
        System.out.println("Length of LCS: " + lcsLength);
    }
}
