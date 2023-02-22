import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[19][19];
    static int[] dx = { 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1 };
    static boolean[][][] visited = new boolean[19][19][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] != 0) {
                    if (check(i, j)) {
                        System.out.println(map[i][j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (visited[x][y][i])
                continue;
            int nx = x + dx[i];
            int ny = y + dy[i];
            int cnt = 1;
            while (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                if (map[nx][ny] != map[x][y])
                    break;
                visited[nx][ny][i] = true;
                nx += dx[i];
                ny += dy[i];
                cnt++;
            }
            if (cnt == 5) {
                int nx2 = x - dx[i];
                int ny2 = y - dy[i];
                if (nx2 >= 0 && nx2 < 19 && ny2 >= 0 && ny2 < 19) {
                    if (map[nx2][ny2] == map[x][y])
                        return false;
                }
                return true;
            }
        }
        return false;
    }
}
