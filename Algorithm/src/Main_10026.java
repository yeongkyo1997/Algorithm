import java.io.*;
import java.util.StringTokenizer;

public class Main_10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static char[][] map;
    static int normal = 0;
    static int special = 0;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    normal++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R') map[i][j] = 'G';
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    special++;
                }
            }
        }

        bw.write(normal + " " + special + "\n");
        bw.close();
    }

    static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == color) dfs(nx, ny, color);
        }
    }
}