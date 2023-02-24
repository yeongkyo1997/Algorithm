import java.io.*;
import java.util.StringTokenizer;

public class Main_3109 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.close();
    }

    static boolean dfs(int x, int y) {
        if (y == C - 1) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (map[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (dfs(nx, ny)) return true;
                }
            }
        }
        return false;
    }
}