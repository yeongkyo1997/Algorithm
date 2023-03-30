import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2239_스도쿠 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] board = new int[9][9];
    static List<int[]> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) - '0';
                if (board[i][j] == 0) list.add(new int[]{i, j});
            }
        }
        sudoku(0);
    }

    static boolean check(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == value) return false;
            if (board[i][y] == value) return false;
        }

        int nx = x / 3 * 3;
        int ny = y / 3 * 3;

        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (board[i][j] == value) return false;
            }
        }
        return true;
    }

    static void sudoku(int depth) {
        if (depth == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        int x = list.get(depth)[0];
        int y = list.get(depth)[1];

        for (int i = 1; i <= 9; i++) {
            if (check(x, y, i)) {
                board[x][y] = i;
                sudoku(depth + 1);
                board[x][y] = 0;
            }
        }
    }
}
