<<<<<<< HEAD
import java.io.*;
=======
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2
import java.util.StringTokenizer;

public class Main_17626 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
<<<<<<< HEAD
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        bw.write(dp[n] + "");
        bw.close();
=======
        int N = Integer.parseInt(br.readLine());
>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2
    }
}
