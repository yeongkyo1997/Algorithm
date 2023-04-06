import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2447_별_찍기_10 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static char[][] list;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        list = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(list[i], ' ');
        }

        solve(0, 0, N);

        for (char[] chars : list) {
            for (char ch : chars) {
                bw.write(String.valueOf(ch));
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void solve(int x, int y, int depth) {
        if (depth == 1) {
            list[x][y] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    solve(x + i * (depth / 3), y + j * (depth / 3), depth / 3);
                }
            }
        }
    }
}
