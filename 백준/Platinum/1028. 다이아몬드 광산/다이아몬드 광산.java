import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int row, col;
    static int[][] DP1 = new int[770][770];
    static int[][] DP2 = new int[770][770];
    static int[][] DP3 = new int[770][770];
    static int[][] DP4 = new int[770][770];
    static char[][] map = new char[770][770];

    static boolean isOut(int x, int y) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i <= row + col - 2; i++) {
            for (int j = 0; j < col; j++) {
                int r = i - j;

                if (isOut(r, j)) continue;

                if (isOut(r + 1, j - 1)) DP3[r][j] = (map[r][j] == '1' ? 1 : 0);

                else DP3[r][j] = (map[r][j] == '1' ? 1 : 0) * (DP3[r + 1][j - 1] + 1);
            }
            for (int j = 0; j < row; j++) {
                int c = i - j;

                if (isOut(j, c)) continue;

                if (isOut(j - 1, c + 1)) DP1[j][c] = (map[j][c] == '1' ? 1 : 0);

                else DP1[j][c] = (map[j][c] == '1' ? 1 : 0) * (DP1[j - 1][c + 1] + 1);
            }
        }
        for (int i = 1 - col; i <= row - 1; i++) {

            for (int j = 0; j < row; j++) {

                int c = j - i;

                if (isOut(j, c)) continue;

                if (isOut(j - 1, c - 1)) DP4[j][c] = (map[j][c] == '1' ? 1 : 0);

                else DP4[j][c] = (map[j][c] == '1' ? 1 : 0) * (DP4[j - 1][c - 1] + 1);
            }
            for (int j = row - 1; j >= 0; j--) {

                int c = j - i;

                if (isOut(j, c)) continue;

                if (isOut(j + 1, c + 1)) DP2[j][c] = (map[j][c] == '1' ? 1 : 0);

                else DP2[j][c] = (map[j][c] == '1' ? 1 : 0) * (DP2[j + 1][c + 1] + 1);
            }
        }

        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int min = Math.min(DP1[i][j], DP2[i][j]);

                if (min < result) continue;

                for (int k = min; k >= 1; k--) {
                    if (j + 2 * (k - 1) >= col) continue;

                    if (k < result) break;

                    if (Math.min(DP3[i][j + 2 * (k - 1)], DP4[i][j + 2 * (k - 1)]) >= k) {
                        result = Math.max(result, k);
                        break;
                    }
                }
            }
        }
        bw.write(result + "");
        bw.close();
    }
}
