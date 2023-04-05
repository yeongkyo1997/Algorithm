import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_2156_포도주_시식 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];
        int[] arr = new int[n + 1];

        for (int i = 1; i < n + 1; i++) arr[i] = Integer.parseInt(br.readLine());


        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(Math.max(arr[1] + arr[2], arr[1] + arr[3]), Math.max(arr[2], arr[3]));

        IntStream.range(4, n + 1).forEach(i -> dp[i] = Math.max(Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]), dp[i - 1]));

        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}
