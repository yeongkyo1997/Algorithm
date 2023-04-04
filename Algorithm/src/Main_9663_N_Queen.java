import java.io.*;
import java.util.StringTokenizer;

public class Main_9663_N_Queen {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] board; // 체스판
    private static int N; // 체스판 크기
    private static int cnt; // 경우의 수

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        cnt = 0;

        solve(0);

        bw.write(String.valueOf(cnt));
        bw.close();
    }


    static boolean check(int x, int y) {
        for (int i = 0; i < N; i++) {
            if (board[x][i] == 1) return false; // 세로
            if (board[i][y] == 1) return false; // 가로
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Math.abs(x - i) == Math.abs(y - j)) { // 대각선
                    if (board[i][j] == 1) return false;
                }
            }
        }
        return true;

    }

    /*
     * depth : 행
     */
    static void solve(int depth) {
        if (depth == N) { // 행이 N이 되면
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check(depth, i)) { // 퀸을 놓을 수 있는지 확인
                board[depth][i] = 1; // 퀸을 놓는다.
                solve(depth + 1); // 다음 행으로 넘어간다.
                board[depth][i] = 0; // 퀸을 뺀다.
            }
        }
    }
}
