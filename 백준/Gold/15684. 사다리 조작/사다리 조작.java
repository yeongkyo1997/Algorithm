import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, H;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boolean[][] ladder = new boolean[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a, b;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }
        int result = addLadder(ladder, 0, 1, 1);
        bw.write(String.valueOf(result >= 4 ? -1 : result));
        bw.close();
    }

    static boolean checkLadder(boolean[][] ladder) {
        for (int start = 1; start <= N; start++) {
            int k = start;
            for (int h = 1; h <= H; h++) {
                if (ladder[h][k])
                    k++;
                else if (k > 1 && ladder[h][k - 1])
                    k--;
            }
            if (k != start)
                return false;
        }
        return true;
    }

    static int addLadder(boolean[][] ladder, int cnt, int x, int y) {
        if (cnt >= 4)
            return 4;

        if (checkLadder(ladder))
            return cnt;
        int result = 4;
        for (int i = x; i <= H; i++) {
            int kStart = i != x ? 1 : y;
            for (int k = kStart; k < N; k++) {
                if (!ladder[i][k] && !ladder[i][k - 1] && !ladder[i][k + 1]) {
                    ladder[i][k] = true;
                    int tmp = addLadder(ladder, cnt + 1, i, k + 2);
                    result = Math.min(result, tmp);
                    ladder[i][k] = false;
                }
            }
        }
        return result;
    }
}