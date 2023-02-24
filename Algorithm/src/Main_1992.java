import java.io.*;
import java.util.StringTokenizer;

public class Main_1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
<<<<<<< HEAD
    private static int[][] list;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        list = new int[N][N];
=======
    static int N;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
<<<<<<< HEAD
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
=======
                map[i][j] = str.charAt(j) - '0';
            }
        }

        quardTree(0, 0, N);
        bw.close();
    }

    static boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (map[x][y] != map[i][j]) {
                    return false;
                }
>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2
            }
        }
        return true;
    }
<<<<<<< HEAD
=======


    static void quardTree(int x, int y, int n) throws IOException {
        if (check(x, y, n)) {
            bw.write(map[x][y] + "");
        } else {
            int m = n / 2;
            bw.write("(");
            quardTree(x, y, m);
            quardTree(x, y + m, m);
            quardTree(x + m, y, m);
            quardTree(x + m, y + m, m);
            bw.write(")");
        }
    }
>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2
}
