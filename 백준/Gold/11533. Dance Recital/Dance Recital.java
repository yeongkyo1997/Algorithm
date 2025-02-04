import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int R = Integer.parseInt(br.readLine().trim());
        String[] routines = new String[R];
        for (int i = 0; i < R; i++) {
            routines[i] = br.readLine().trim();
        }

        int[] routineMask = new int[R];
        for (int i = 0; i < R; i++) {
            int mask = 0;
            for (char ch : routines[i].toCharArray()) {
                mask |= (1 << (ch - 'A'));
            }
            routineMask[i] = mask;
        }

        int[][] cost = new int[R][R];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                if (i == j)
                    continue;

                int common = Integer.bitCount(routineMask[i] & routineMask[j]);
                cost[i][j] = common;
            }
        }

        int fullMask = (1 << R) - 1;
        int[][] dp = new int[1 << R][R];
        for (int i = 0; i < (1 << R); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        for (int i = 0; i < R; i++) {
            dp[1 << i][i] = 0;
        }

        for (int mask = 0; mask < (1 << R); mask++) {
            for (int last = 0; last < R; last++) {
                if ((mask & (1 << last)) == 0)
                    continue;
                for (int k = 0; k < R; k++) {
                    if ((mask & (1 << k)) != 0)
                        continue;
                    int nextMask = mask | (1 << k);
                    dp[nextMask][k] = Math.min(dp[nextMask][k], dp[mask][last] + cost[last][k]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            answer = Math.min(answer, dp[fullMask][i]);
        }

        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}