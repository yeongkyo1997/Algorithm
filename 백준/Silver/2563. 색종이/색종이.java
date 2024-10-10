import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[1000][1000];
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int row = x; row < x + 10; row++) {
                for (int col = y; col < y + 10; col++) {
                    board[row][col] = 1;
                }
            }
        }

        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (board[i][j] == 1)
                    result++;
            }
        }
        bw.write(result + "");
        bw.close();
    }
}