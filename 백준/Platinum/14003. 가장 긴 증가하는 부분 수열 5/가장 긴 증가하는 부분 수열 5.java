import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] a;
        int[] dp;
        int[] path;

        a = new int[N];
        dp = new int[N];
        path = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = len;
            while (start < end) {
                int mid = (start + end) / 2;
                if (dp[mid] < a[i]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            dp[start] = a[i];
            path[i] = start;
            if (start == len) {
                len++;
            }
        }

        bw.write(len + "\n");

        int[] ans = new int[len];

        int idx = len - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (path[i] == idx) {
                ans[idx] = a[i];
                idx--;
            }
        }

        for (int i = 0; i < len; i++) {
            bw.write(ans[i] + " ");
        }
        bw.close();
    }
}