import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int n;
    static int result = 0;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < 101; i++) {
            visited = new int[n][n];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] > i && visited[j][k] == 0) {
                        cnt++;
                        dfs(j, k, i);
                    }
                }
            }
            result = Math.max(cnt, result);
        }
        if (result == 0)
            result = 1;
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int height) {
        visited[x][y] = 1;
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == 0 && map[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }
    }
}
