import java.io.*;
import java.util.StringTokenizer;

// BOJ 9252 LCS 2
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        char[][] path = new char[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    path[i][j] = 'D';
                } else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                        path[i][j] = 'U';
                    } else {
                        dp[i][j] = dp[i][j - 1];
                        path[i][j] = 'L';
                    }
                }
            }
        }

        bw.write(dp[a.length()][b.length()] + "\n");

        int i = a.length();
        int j = b.length();
        StringBuilder sb = new StringBuilder();
        while (path[i][j] != 0) {
            if (path[i][j] == 'D') {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (path[i][j] == 'U') {
                i--;
            } else {
                j--;
            }
        }

        bw.write(sb.reverse().toString());

        bw.close();
    }
}