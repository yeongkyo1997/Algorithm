import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 1315 RPG
public class Main_1315 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Power implements Comparable<Power> {
        int STR;
        int INT;
        int PNT;

        public Power(int STR, int INT, int PNT) {
            this.STR = STR;
            this.INT = INT;
            this.PNT = PNT;
        }

        @Override
        public int compareTo(Power o) {
            if (o.PNT == this.PNT) if (o.INT == this.INT) return o.STR - this.STR;
            else return o.INT - this.INT;
            else return o.PNT - this.PNT;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Power[] powers = new Power[N];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int STR = Integer.parseInt(st.nextToken());
            int INT = Integer.parseInt(st.nextToken());
            int PNT = Integer.parseInt(st.nextToken());
            powers[i] = new Power(STR, INT, PNT);
        }
        Arrays.sort(powers);

        dp[0][0] = powers[0].STR;
        dp[0][1] = powers[0].INT;
        dp[0][2] = powers[0].PNT;

        int max = 0;
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], powers[i].STR);
            dp[i][1] = Math.max(dp[i - 1][1], powers[i].INT);
            dp[i][2] = Math.max(dp[i - 1][2], powers[i].PNT);
            max = Math.max(max, dp[i][0] + dp[i][1] + dp[i][2]);
        }

        bw.write(max + "\n");
        bw.close();

    }
}