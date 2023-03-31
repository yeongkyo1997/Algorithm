import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m;
    static int[][] map = new int[101][101];
    static int[] row = {-1, 1, 0, 0};
    static int[] col = {0, 0, -1, 1};

    static void airOut(int[][] ac, int sero, int garo) {
        ac[sero][garo] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = sero + row[i];
            int nx = garo + col[i];

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
        int pre_rcn = 0;

        while (true) {

            int[][] air_check = new int[101][101];


            airOut(air_check, 0, 0);


            int[][] remove_ch = new int[10000][2];
            int remove_ch_num = 0;


            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (map[i][j] == 1) {
                        for (int d = 0; d < 4; d++) {
                            int cy = i + row[d];
                            int cx = j + col[d];

                            if (cy >= 0 && cy < n && cx >= 0 && cx < m) {
                                if (air_check[cy][cx] == 1) {

                                    remove_ch[remove_ch_num][0] = i;
                                    remove_ch[remove_ch_num++][1] = j;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            if (remove_ch_num == 0) break;
            pre_rcn = remove_ch_num;


            for (int r = 0; r < remove_ch_num; r++)
                map[remove_ch[r][0]][remove_ch[r][1]] = 0;

            time++;
        }
        bw.write(time + "\n" + pre_rcn);
        bw.close();
    }
}