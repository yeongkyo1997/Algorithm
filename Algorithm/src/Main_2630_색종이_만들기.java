import java.io.*;
import java.util.StringTokenizer;

public class Main_2630_색종이_만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(0, 0, N);
        bw.write(white + "\n");
        bw.write(blue + "\n");
        bw.close();
    }

    static boolean check(int x, int y, int N) {
        int color = map[x][y];
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (map[i][j] != color) return false;
            }
        }
        if (color == 0) white++;
        else blue++;
        return true;

    }

    static void recursion(int startX, int startY, int N) {
        if (check(startX, startY, N)) return;

        recursion(startX, startY, N / 2);
        recursion(startX + N / 2, startY, N / 2);
        recursion(startX, startY + N / 2, N / 2);
        recursion(startX + N / 2, startY + N / 2, N / 2);

    }
}