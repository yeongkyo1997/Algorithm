import java.io.*;
import java.util.StringTokenizer;

public class Main_1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int[][] list;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        list = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                list[i][j] = str.charAt(j);
            }
        }
    }

    static void solve(int x, int y, int N) throws IOException {
        if (N == 1) return;
        if (check(x, y, N)) {
            bw.write(list[x][y] + "");
        }

        bw.write("(" + "");
        solve(x, y, N / 2);
        bw.write("(" + "");
        solve(x, y / 2, N / 2);
        bw.write("(" + "");
        solve(x / 2, y / 2, N / 2);
        bw.write("(" + "");
        solve(x / 2, y / 2, N / 2);
    }

    static boolean check(int x, int y, int N) {
        int val = list[x][y];

        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (val != list[x][y]) return false;
            }
        }
        return true;
    }
}
