import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2615 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] board = new int[19][19];
    static int[] dx = { 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1 };
    static boolean[][][] visited = new boolean[19][19][4];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    if (check(i, j)) {
                        bw.write(board[i][j] + "\n");
                        bw.write((i + 1) + " " + (j + 1));
                        bw.flush();
                        return;
                    }
                }
            }
        }
        bw.write("0");
        bw.flush();
    }

    static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (visited[x][y][i])
                continue;
            int nx = x + dx[i];
            int ny = y + dy[i];
            int cnt = 1;
            while (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                if (board[nx][ny] != board[x][y])
                    break;
                visited[nx][ny][i] = true;
                nx += dx[i];
                ny += dy[i];
                cnt++;
            }
            if (cnt == 5) {
                int nx2 = x - dx[i];
                int ny2 = y - dy[i];
                if (nx2 >= 0 && nx2 < 19 && ny2 >= 0 && ny2 < 19) {
                    if (board[nx2][ny2] == board[x][y])
                        return false;
                }
                return true;
            }
        }
        return false;
    }
}
