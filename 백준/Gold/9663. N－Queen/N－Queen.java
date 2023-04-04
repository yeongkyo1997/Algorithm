import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] board = new int[15];
    static int result = 0;

    static public void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dfs(0);
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    static boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            if (board[i] == board[depth] || Math.abs(board[depth] - board[i]) == depth - i)
                return false;
        }
        return true;
    }

    static void dfs(int row) {
        if (row == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            board[row] = i;
            if (check(row))
                dfs(row + 1);
        }
    }
}
