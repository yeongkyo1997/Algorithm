import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a = new int[105];
    static int[] b = new int[105];
    static String s1, s2;
    static int[][][][] dp = new int[105][15][15][15];

    public static void main(String[] args) {
        FastReader in = new FastReader();
        n = in.nextInt();
        s1 = in.next();
        s2 = in.next();

        for (int i = 1; i <= n; i++) {
            a[i] = s1.charAt(i - 1) - '0';
        }
        for (int i = 1; i <= n; i++) {
            b[i] = s2.charAt(i - 1) - '0';
        }

        for (int[][][] array3D : dp)
            for (int[][] array2D : array3D)
                for (int[] array1D : array2D)
                    Arrays.fill(array1D, -1);

        System.out.println(dp(1, a[1], a[2], a[3]));
    }

    static int dp(int now, int x, int y, int z) {
        if (now > n) return 0;
        if (dp[now][x][y][z] != -1) return dp[now][x][y][z];
        dp[now][x][y][z] = 1_000_000_000;
        int ck = (b[now] - x + 10) % 10;
        int[] d = {ck, 10 - ck};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= d[i]; j++) {
                for (int k = 0; k <= j; k++) {
                    int yy = (y + (i != 0 ? -j : j) + 10) % 10;
                    int zz = (z + (i != 0 ? -k : k) + 10) % 10;
                    int val = dp(now + 1, yy, zz, a[now + 3]);
                    val += (d[i] - j + 2) / 3 + (j - k + 2) / 3 + (k + 2) / 3;
                    dp[now][x][y][z] = Math.min(dp[now][x][y][z], val);
                }
            }
        }
        return dp[now][x][y][z];
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}