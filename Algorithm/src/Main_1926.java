import java.io.*;
import java.util.*;

public class Main_1926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int n;
    private static int m;
    private static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                    result.add(dfs(i, j));
                }
            }
        }
        if (cnt == 0) {
            bw.write(0 + "\n");
            bw.write(0 + "");
        } else {
            bw.write(cnt + "\n");
            bw.write(result.stream().mapToInt(x -> x).max().getAsInt() + "");
        }
        bw.close();
    }

    static int dfs(int x, int y) {
        int cnt = 1;
        map[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1) {
                cnt += dfs(nx, ny);
            }
        }
        return cnt;
    }
}