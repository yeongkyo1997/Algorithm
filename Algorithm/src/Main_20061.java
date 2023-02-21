import java.io.*;
import java.util.StringTokenizer;

public class Main_20061 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean visited[][];
    static int N;
    static int[][] map = new int[10][4];
    static int[][] green = new int[6][4];
    static int[][] blue = new int[4][6];
    static int score = 0;
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (t == 1) {
                green[x][y] = 1;
                blue[y][x] = 1;
            } else if (t == 2) {
                green[x][y] = 1;
                green[x][y + 1] = 1;
                blue[y][x] = 1;
                blue[y + 1][x] = 1;
            } else if (t == 3) {
                green[x][y] = 1;
                green[x + 1][y] = 1;
                blue[y][x] = 1;
                blue[y][x + 1] = 1;
            }
            visited = new boolean[6][4];
            dfs(0, 0);
            visited = new boolean[4][6];
            dfs(0, 0);
        }
        bw.write(score + "\n");
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        if (x == 6) {
            int cnt = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    if (visited[i][j]) cnt++;
                }
            }
            if (cnt == 24) {
                score++;
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (visited[i][j]) {
                            green[i][j] = 0;
                            blue[j][i] = 0;
                        }
                    }
                }
            }
            return;
        }
        if (y == 4) {
            dfs(x + 1, 0);
            return;
        }
        if (visited[x][y]) {
            dfs(x, y + 1);
            return;
        }
        if (green[x][y] == 1) {
            visited[x][y] = true;
            dfs(x, y + 1);
            visited[x][y] = false;
        } else {
            dfs(x, y + 1);
        }
    }
}