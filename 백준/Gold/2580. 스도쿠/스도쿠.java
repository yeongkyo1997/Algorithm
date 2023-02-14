import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int BOARD_SIZE = 9;
    static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    static ArrayList<Pair> list = new ArrayList<>();

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < BOARD_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0)
                    list.add(new Pair(i, j));
            }
        }
        sol(0);
    }

    static boolean check(int x, int y, int num) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[x][i] == num || board[i][y] == num) {
                return false;
            }
        }
        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static void sol(int depth) throws IOException {
        if (depth == list.size()) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    bw.write(board[i][j] + " ");
                }
                bw.write("\n" + "");
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }
        for (int i = 1; i < 10; i++) {
            Pair pair = list.get(depth);
            if (check(pair.x, pair.y, i)) {
                board[pair.x][pair.y] = i;
                sol(depth + 1);
                board[pair.x][pair.y] = 0;
            }
        }
    }
}
