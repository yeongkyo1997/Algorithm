import java.io.*;
import java.util.StringTokenizer;

public class Main_20061 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    static int[][] map = new int[10][4];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            put(t, x, y);
            check();

        }

        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] != 0) cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.close();
    }

    static void put(int t, int x, int y) {
        if (t == 1) {
            for (int i = 0; i < 4; i++) {
                if (map[x][i] == 0) {
                    map[x][i] = 1;
                    break;
                }
            }
        } else if (t == 2) {
            for (int i = 0; i < 4; i++) {
                if (map[x][i] == 0 && map[x][i + 1] == 0) {
                    map[x][i] = 2;
                    map[x][i + 1] = 2;
                    break;
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (map[x][i] == 0 && map[x + 1][i] == 0) {
                    map[x][i] = 3;
                    map[x + 1][i] = 3;
                    break;
                }
            }
        }
    }

    static void check() {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (map[5][i] != 0) cnt++;
        }
        if (cnt == 4) {
            for (int i = 5; i > 0; i--) {
                for (int j = 0; j < 4; j++) {
                    map[i][j] = map[i - 1][j];
                }
            }
            for (int i = 0; i < 4; i++) {
                map[0][i] = 0;
            }
        }
    }
}
