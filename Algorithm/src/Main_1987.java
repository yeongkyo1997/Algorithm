import java.io.*;
import java.util.StringTokenizer;

// BOJ 1987 알파벳
public class Main_1987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int R;
    private static int C;
    private static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[] visited = new boolean[26];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 1);
        bw.write(result + "\n");
        bw.close();
    }

    static void dfs(int x, int y, int cnt) {
        visited[map[x][y] - 'A'] = true;
        result = Math.max(result, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (visited[map[nx][ny] - 'A']) continue;

            dfs(nx, ny, cnt + 1);
            visited[map[nx][ny] - 'A'] = false;
        }
    }
}
