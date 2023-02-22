import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[][] paper = new int[128][128];
    static int blue, white;

    static void solve(int y, int x, int size) {
        int check = paper[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (check == 0 && paper[i][j] == 1) {
                    check = 2;
                } else if (check == 1 && paper[i][j] == 0) {
                    check = 2;
                }
                if (check == 2) {
                    solve(y, x, size / 2);
                    solve(y, x + size / 2, size / 2);
                    solve(y + size / 2, x, size / 2);
                    solve(y + size / 2, x + size / 2, size / 2);
                    return;
                }
            }
        }

        if (check == 0) {
            white++;
        } else {
            blue++;
        }

    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, n);
        bw.write(white + "\n");
        bw.write(blue + "\n");
        bw.flush();
        bw.close();
    }
}