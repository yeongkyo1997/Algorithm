import java.io.*;
import java.util.StringTokenizer;

public class Main_1992_쿼드트리 {
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
                list[i][j] = str.charAt(j) - '0';
            }
        }

        solve(N, 0, 0);
        bw.close();
    }

    static boolean checked(int N, int x, int y) {
        int tmp = list[x][y];

        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (list[i][j] != tmp) return false;
            }
        }

        return true;
    }

    static void solve(int N, int x, int y) throws IOException {
        if (checked(N, x, y)) {
            bw.write(list[x][y] + "");
            return;
        }

        int size = N / 2;
        bw.write("(");
        solve(size, x, y);
        solve(size, x, y + size);
        solve(size, x + size, y);
        solve(size, x + size, y + size);
        bw.write(")");
    }
}
