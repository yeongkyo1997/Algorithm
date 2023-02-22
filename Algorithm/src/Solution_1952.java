import java.io.*;
import java.util.StringTokenizer;

// SWEA 1952. 수영장
// dfs
public class Solution_1952 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int[] price = new int[4];
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            int[] month = new int[12];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                month[i] = Integer.parseInt(st.nextToken());
            }

            int ans = dfs(month, price, 0, 0);
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.close();
    }

    static int dfs(int[] month, int[] price, int idx, int sum) {
        if (idx >= 12) {
            return sum;
        }

        int ans = Integer.MAX_VALUE;
        if (month[idx] == 0) {
            ans = Math.min(ans, dfs(month, price, idx + 1, sum));
        } else {
            ans = Math.min(ans, dfs(month, price, idx + 1, sum + month[idx] * price[0]));
            ans = Math.min(ans, dfs(month, price, idx + 1, sum + price[1]));
            ans = Math.min(ans, dfs(month, price, idx + 3, sum + price[2]));
        }
        return Math.min(ans, price[3]);
    }
}

