import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] board = new int[9][9];
    static List<int[]> zero = new ArrayList<>();

    static boolean check(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num)
                return false;
            if (board[i][y] == num)
                return false;
        }

        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    static void dfs(int depth) throws IOException {
        if (depth == zero.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(board[i][j] + " ");
                }
                bw.newLine();
            }
            bw.close();
            System.exit(0);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int[] node = zero.get(depth);
            int x = node[0];
            int y = node[1];

            if (check(x, y, i)) {
                board[x][y] = i;
                dfs(depth + 1);
                board[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0)
                    zero.add(new int[] { i, j });
            }
        }

        dfs(0);
    }
}