import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15683 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] a;
    static int[][] b;
    static int[] v;
    static int result = Integer.MAX_VALUE;
    static int U = 0, D = 1, L = 4, R = 8;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        a = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] != 0 && a[i][j] != 6) {
                    cnt++;
                }
            }
        }

        v = new int[cnt * 2];
        Arrays.fill(v, -1);
        solve(0);

        bw.write(result + "");
        bw.close();
    }

    static void observe(int x, int y, int dir) {
        if (dir == U) {
            for (int i = x; i >= 0; i--) {
                if (a[i][y] == 6) break;
                b[i][y] = 1;
            }
        } else if (dir == D) {
            for (int i = x; i < a.length; i++) {
                if (a[i][y] == 6) break;
                b[i][y] = 1;
            }
        } else if (dir == L) {
            for (int i = y; i >= 0; i--) {
                if (a[x][i] == 6) break;
                b[x][i] = 1;
            }
        } else if (dir == R) {
            for (int i = y; i < a[0].length; i++) {
                if (a[x][i] == 6) break;
                b[x][i] = 1;
            }
        }
    }

    static void solve(int depth) {
        if (depth == v.length) {
            b = new int[a.length][a[0].length];
            for (int i = 0; i < a.length; i++) {
                System.arraycopy(a[i], 0, b[i], 0, a[0].length);
            }
            for (int i = 0; i < v.length; i += 2) {
                int x = v[i];
                int y = v[i + 1];
                if (b[x][y] == 1) {
                    observe(x, y, U);
                    observe(x, y, D);
                    observe(x, y, L);
                    observe(x, y, R);
                } else if (b[x][y] == 2) {
                    observe(x, y, U);
                    observe(x, y, D);
                } else if (b[x][y] == 3) {
                    observe(x, y, L);
                    observe(x, y, R);
                } else if (b[x][y] == 4) {
                    observe(x, y, U);
                    observe(x, y, L);
                    observe(x, y, R);
                } else if (b[x][y] == 5) {
                    observe(x, y, U);
                    observe(x, y, D);
                    observe(x, y, L);
                    observe(x, y, R);
                }
            }
            int cnt = 0;
            for (int[] ints : b) {
                for (int j = 0; j < b[0].length; j++) {
                    if (ints[j] == 0) cnt++;
                }
            }
            result = Math.min(result, cnt);
            return;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0 && a[i][j] != 6) {
                    v[depth] = i;
                    v[depth + 1] = j;
                    solve(depth + 2);
                }
            }
        }
    }
}