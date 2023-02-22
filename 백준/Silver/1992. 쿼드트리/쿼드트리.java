import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
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
            }
        }
        return true;
    }


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
}