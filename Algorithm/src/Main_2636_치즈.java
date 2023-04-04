import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m;
    static int[][] map = new int[101][101];
    static int[] row = {-1, 1, 0, 0};
    static int[] col = {0, 0, -1, 1};

    static void airOut(int[][] ac, int r, int c) {
        ac[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = r + row[i];
            int nx = c + col[i];

            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (map[ny][nx] == 0 && ac[ny][nx] == 0) airOut(ac, ny, nx);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        int preCnt = 0;

        while (true) {

            int[][] airCheck = new int[101][101];


            airOut(airCheck, 0, 0);


            int[][] removeCh = new int[10000][2];
            int removeChNum = 0;


            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (map[i][j] == 1) {
                        for (int d = 0; d < 4; d++) {
                            int dy = i + row[d];
                            int dx = j + col[d];

                            if (dy >= 0 && dy < n && dx >= 0 && dx < m) {
                                if (airCheck[dy][dx] == 1) {

                                    removeCh[removeChNum][0] = i;
                                    removeCh[removeChNum++][1] = j;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            if (removeChNum == 0) break;
            preCnt = removeChNum;


            for (int r = 0; r < removeChNum; r++)
                map[removeCh[r][0]][removeCh[r][1]] = 0;

            time++;
        }
        bw.write(time + "\n" + preCnt);
        bw.close();
    }
}
