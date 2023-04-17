import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[2001][2001];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        IntStream.range(0, 2001).forEach(i -> Arrays.fill(dp[i], -1));
        bw.write(String.valueOf(solve(0, N - 1, 1)));
        bw.close();
    }

    static int solve(int left, int right, int day) {
        if (left > right) return 0;
        if (dp[left][right] != -1) return dp[left][right];
        return dp[left][right] = Math.max(arr[left] * day + solve(left + 1, right, day + 1), arr[right] * day + solve(left, right - 1, day + 1));
    }
}