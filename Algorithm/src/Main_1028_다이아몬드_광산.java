import java.io.*;
import java.util.StringTokenizer;

public class Main_1028_다이아몬드_광산 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int R, C;
    static char[][] map;
    static int[][] dp1, dp2, dp3, dp4;

    static boolean isOut(int r, int c) {
        return r < 0 || r >= R || c < 0 || c >= C;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        dp1 = new int[R][C];
        dp2 = new int[R][C];
        dp3 = new int[R][C];
        dp4 = new int[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int d = 0; d <= R + C - 2; d++) {
            for (int c = 0; c < C; c++) {
                int r = d - c;

                if (isOut(r, c)) continue;

                if (isOut(r + 1, c - 1)) dp3[r][c] = (map[r][c] == '1') ? 1 : 0;
                else dp3[r][c] = (map[r][c] == '1') ? dp3[r + 1][c - 1] + 1 : 0;
            }
            for (int r = 0; r < R; r++) {
                int c = d - r;

                if (isOut(r, c)) continue;

                if (isOut(r - 1, c + 1)) dp1[r][c] = (map[r][c] == '1') ? 1 : 0;
                else dp1[r][c] = (map[r][c] == '1') ? dp1[r - 1][c + 1] + 1 : 0;
            }
        }
        for (int d = 1 - C; d <= R - 1; d++) {
            for (int r = 0; r < R; r++) {
                int c = r - d;

                if (isOut(r, c)) continue;

                if (isOut(r - 1, c - 1)) dp4[r][c] = (map[r][c] == '1') ? 1 : 0;
                else dp4[r][c] = (map[r][c] == '1') ? dp4[r - 1][c - 1] + 1 : 0;
            }
            for (int r = R - 1; r >= 0; r--) {
                int c = r - d;

                if (isOut(r, c)) continue;

                if (isOut(r + 1, c + 1)) dp2[r][c] = (map[r][c] == '1') ? 1 : 0;
                else dp2[r][c] = (map[r][c] == '1') ? dp2[r + 1][c + 1] + 1 : 0;
            }
        }

        int mx = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int mxSide = Math.min(dp1[r][c], dp2[r][c]);

                if (mxSide < mx) continue;

                for (int sz = mxSide; sz >= 1; sz--) {
                    if (c + 2 * (sz - 1) >= C) continue;

                    if (sz < mx) break;

                    if (Math.min(dp3[r][c + 2 * (sz - 1)], dp4[r][c + 2 * (sz - 1)]) >= sz) {
                        mx = sz;
                        break;
                    }
                }
            }
        }
        bw.write(mx + "");
        bw.close();
    }
}