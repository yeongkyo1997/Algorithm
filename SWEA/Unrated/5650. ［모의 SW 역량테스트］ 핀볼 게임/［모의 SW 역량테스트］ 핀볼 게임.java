import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int[][] area;
    static int[][] block = {{}, {2, 0, 3, 1}, {2, 3, 1, 0}, {1, 3, 0, 2}, {3, 2, 0, 1}, {2, 3, 0, 1}};
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Pair[][] warm;
    static int T, sr, sc, sp;

    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int go(int r, int c, int d) {
        if (sr == r && sc == c && sp == 1) return 0;
        sp = 1;
        int ret = 0;
        int nr = r + dr[d], nc = c + dc[d];
        int num = area[nr][nc];
        if (num != -1) {
            if (num == 0) ret = go(nr, nc, d);
            else if (0 < num && num < 6) ret = go(nr, nc, block[num][d]) + 1;
            else {
                if (warm[0][num].r == nr && warm[0][num].c == nc) ret = go(warm[1][num].r, warm[1][num].c, d);
                else ret = go(warm[0][num].r, warm[0][num].c, d);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt();
            area = new int[n + 2][n + 2];
            warm = new Pair[2][15];
            for (int i = 0; i <= n + 1; i++) {
                for (int j = 0; j <= n + 1; j++) {
                    if (i == 0 || j == 0 || i == n + 1 || j == n + 1) area[i][j] = 5;
                    else {
                        int num = scanner.nextInt();
                        area[i][j] = num;
                        if (5 < num) {
                            if (warm[0][num] == null) warm[0][num] = new Pair(i, j);
                            else warm[1][num] = new Pair(i, j);
                        }
                    }
                }
            }

            int result = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (area[i][j] == 0) {
                        sr = i;
                        sc = j;
                        for (int d = 0; d < 4; d++) {
                            sp = 0;
                            result = Math.max(result, go(i, j, d));
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", t, result);
        }
    }
}