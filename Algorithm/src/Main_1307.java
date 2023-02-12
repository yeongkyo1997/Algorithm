import java.io.*;
import java.util.StringTokenizer;

public class Main_1307 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] list;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new int[N][N];

        int num = 1;

        if (N % 2 == 0) {

        } else {
            list[N - 1][N / 2] = 1;
            odd(N - 1, N / 2, 2);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void odd(int x, int y, int cnt) {
        while (cnt <= N * N) {
            if (x + 1 >= N && y + 1 >= N) {
                x -= 1;
                list[x][y] = cnt++;
            } else if (x + 1 >= N) {
                x = 0;
                list[x][++y] = cnt++;
            } else if (y + 1 >= N) {
                y = 0;
                list[++x][y] = cnt++;
            } else if (list[x + 1][y + 1] != 0) {
                list[--x][y] = cnt++;
            } else {
                list[++x][++y] = cnt++;
            }
        }
    }

    static void even(int N) {
        if (N % 4 == 0) {

        }

    }
}
