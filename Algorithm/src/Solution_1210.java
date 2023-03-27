import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1210 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N = 100;
    static int[][] map = new int[N][N];

    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());
            int x = 0;
            int y = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                if (map[99][i] == 2) {
                    x = i;
                    y = 99;
                }
            }

            while (true) {
                if (y == 0) {
                    break;
                }
                if (x > 0 && map[y][x - 1] == 1) {
                    while (x > 0 && map[y][x - 1] == 1) {
                        x--;
                    }
                } else if (x < N - 1 && map[y][x + 1] == 1) {
                    while (x < N - 1 && map[y][x + 1] == 1) {
                        x++;
                    }
                }
                y--;
            }
            bw.write("#" + T + " " + x + "\n");
        }
        bw.flush();
        bw.close();
    }
}
