
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int result;
    static int[][] map;
    static int[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int carblock(int y, int x) {
        int result = map[y][x];
        int max = result;

        if (x + 2 < M) {
            if (y + 1 < N) {
                result += map[y + 1][x + 1] + map[y][x + 1] + map[y][x + 2];
                max = Math.max(result, max);
            }

            if (y - 1 >= 0) {
                result = map[y][x] + map[y - 1][x + 1] + map[y][x + 1] + map[y][x + 2];
                max = Math.max(result, max);
            }
            if (y + 2 < N) {
                if (x - 1 >= 0) {
                    result = map[y][x] + map[y + 1][x - 1] + map[y + 1][x] + map[y + 2][x];
                    max = Math.max(result, max);
                }

                if (x + 1 < M) {
                    result = map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1];
                    max = Math.max(result, max);
                }

            }
        } else if (y + 2 < N) {
            if (x - 1 >= 0) {
                result = map[y][x] + map[y + 1][x - 1] + map[y + 1][x] + map[y + 2][x];
                max = Math.max(result, max);
            }

            if (x + 1 < M) {
                result = map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1];
                max = Math.max(result, max);
            }

        }

        return max;
    }

    static void makeBlock(int y, int x, int num, int sum) {
        if (num == 0) {
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= N || ny < 0 || nx < 0 || nx >= M) continue;
            if (visited[ny][nx] == 0) {
                visited[ny][nx] = 1;
                makeBlock(ny, nx, num - 1, sum + map[ny][nx]);
                visited[ny][nx] = 0;
            }
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = 1;
                makeBlock(i, j, 4 - 1, map[i][j]);
                visited[i][j] = 0;
                result = Math.max(result, carblock(i, j));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        bw.write(result + "");
        bw.close();
    }
}

