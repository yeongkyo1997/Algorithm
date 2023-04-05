import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_14939_불_끄기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][] board = new int[10][10];
    static int[] first = new int[1024];

    static int[] dx = {0, 1, 0, -1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    static void press(int[][] b, int y, int x) {
        for (int i = 0; i < 5; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0 <= ny && ny < 10 && 0 <= nx && nx < 10) b[ny][nx] = (b[ny][nx] + 1) % 2;
        }
    }


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'O') {
                    board[i][j] = 1;
                }
            }
        }

        IntStream.range(0, (1 << 10)).forEach(i -> first[i] = 101);

        for (int t = 0; t < (1 << 10); t++) {
            int[][] tmpBoard = new int[10][10];
            IntStream.range(0, 10).forEach(i -> System.arraycopy(board[i], 0, tmpBoard[i], 0, 10));

            int cnt = 0;

            int bit = 1;
            for (int j = 9; j >= 0; j--) {
                if ((t & bit) != 0) {
                    press(tmpBoard, 0, j);
                    cnt += 1;
                }
                bit <<= 1;
            }

            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (tmpBoard[i - 1][j] == 1) {
                        press(tmpBoard, i, j);
                        cnt += 1;
                    }
                }
            }

            if (Arrays.stream(tmpBoard[9]).sum() == 0) first[t] = cnt;
        }

        int min = 101;
        for (int i = 0; i < (1 << 10); i++) min = Math.min(min, first[i]);
        bw.write(min + "\n");
        bw.close();
    }
}