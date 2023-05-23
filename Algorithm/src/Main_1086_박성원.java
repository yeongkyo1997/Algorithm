import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Main_1086_박성원 {
    static int N, K;
    static int[] nums;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        dp = new long[1 << N][N][K];
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) Arrays.fill(dp[i][j], -1);
        }

        long possibleSolutions = IntStream.range(0, N).mapToLong(i -> find((1 << i), i, nums[i] % K)).sum();

        BigInteger all_permutations = BigInteger.valueOf(N).shiftLeft(N - 1);
        BigInteger gcd = BigInteger.valueOf(possibleSolutions).gcd(all_permutations);

        BigInteger p = BigInteger.valueOf(possibleSolutions).divide(gcd);
        BigInteger q = all_permutations.divide(gcd);

        System.out.println(p + "/" + q);
    }

    static long find(int mask, int idx, int mod) {
        if (mask == (1 << N) - 1) return mod == 0 ? 1 : 0;

        if (dp[mask][idx][mod] != -1) return dp[mask][idx][mod];

        long retval = 0;
        for (int i = 0; i < N; i++) {
            if (((1 << i) & mask) == 0) {
                int next_mod = (int) ((mod * Math.pow(10, (int) Math.log10(nums[i]) + 1) + nums[i]) % K);
                retval += find(mask | (1 << i), i, next_mod);
            }
        }

        return dp[mask][idx][mod] = retval;
    }
}
