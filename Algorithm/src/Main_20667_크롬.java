import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_20667_크롬 {
    static final int MAX = 1000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Table[] arr = new Table[MAX];
    static int[][] dp = new int[1001][2001];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Table();
            arr[i].cpu = Integer.parseInt(st.nextToken());
            arr[i].memory = Integer.parseInt(st.nextToken());
            arr[i].priority = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1000; j >= 0; j--) {
                int pd = j - arr[i].priority;
                if (pd < 0) break;

                for (int c = 2000; c >= 0; c--) {
                    int cd = c - arr[i].cpu;
                    if (cd < 0) break;

                    if ((pd == 0 && cd == 0) || dp[pd][cd] != 0)
                        dp[j][c] = Math.max(dp[j][c], dp[j - arr[i].priority][c - arr[i].cpu] + arr[i].memory);
                }
            }
        }

        int result = -1;
        for (int i = 1000; i >= 0; i--) {
            for (int j = 2000; j >= C; j--) {
                if (dp[i][j] != 0 && dp[i][j] >= M) {
                    if (result == -1 || result > i) result = i;
                }
            }
        }
        bw.write(result + "\n");
        bw.close();
    }

    static class Table {
        int cpu, memory, priority;
    }
}
