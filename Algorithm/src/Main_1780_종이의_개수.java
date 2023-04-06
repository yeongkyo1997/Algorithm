import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1780_종이의_개수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    private static int[][] map;
    private static final int[] cnt = new int[3];

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, n);
        bw.write(cnt[0] + "\n");
        bw.write(cnt[1] + "\n");
        bw.write(cnt[2] + "\n");
        bw.close();
    }

    private static void divide(int x, int y, int size) {
        if (check(x, y, size)) {
            cnt[map[x][y] + 1]++;
            return;
        }
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(x + newSize * i, y + newSize * j, newSize);
            }
        }
    }

    private static boolean check(int x, int y, int size) {
        int num = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}