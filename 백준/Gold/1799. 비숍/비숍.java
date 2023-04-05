import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] board;
    static int[][] wBoard;
    static int[][] bBoard;
    static int[] dx = {-1, 1, 1, -1};
    static int[] dy = {-1, 1, -1, 1};
    static int wCnt = 0;
    static int bCnt = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        wBoard = new int[N][N];
        bBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        wBoard = copy(board);
        bBoard = copy(board);
        checkColor(wBoard, "black");
        checkColor(bBoard, "white");
        solve(0, 0, wBoard, 0);
        wCnt = max;
        max = 0;
        solve(0, 0, bBoard, 0);
        bCnt = max;
        bw.write(wCnt + bCnt + "\n");
        bw.close();
    }

    static int max = 0;

    static void solve(int x, int y, int[][] board, int cnt) {
        if (x == N && y == N - 1) {
            max = Math.max(max, cnt);
            return;
        }
        if (x == N) {
            solve(0, y + 1, board, cnt);
            return;
        }
        if (board[y][x] == 1 && !CheckCollision(x, y, board)) {
            board[y][x] = 2;
            solve(x + 1, y, board, cnt + 1);
            board[y][x] = 1;
            solve(x + 1, y, board, cnt);
        } else {
            solve(x + 1, y, board, cnt);
        }
    }

    static boolean CheckCollision(int x, int y, int[][] board) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            while (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                if (board[ny][nx] == 2) {
                    return true;
                }
                ny += dy[i];
                nx += dx[i];
            }
        }
        return false;
    }

    static int[][] copy(int[][] board) {
        int[][] copy_board = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, copy_board[i], 0, N);
        }
        return copy_board;
    }

    static void checkColor(int[][] arr, String color) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (color.equals("white")) {
                    if ((i + j) % 2 == 0) {
                        arr[i][j] = 0;
                    }
                }
                if (color.equals("black")) {
                    if ((i + j) % 2 != 0) {
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }
}