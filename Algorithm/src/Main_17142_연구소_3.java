import java.io.*;
import java.util.*;

public class Main_17142_연구소_3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int[][] copy;
    static int[] numbers;
    static Queue<int[]> queue;
    static int N, M;
    static int result = Integer.MAX_VALUE;
    static boolean[][] visited;
    static List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        numbers = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        dfs(0, 0);

        if (result == Integer.MAX_VALUE) result = -1;
        bw.write(String.valueOf(result));
        bw.close();
    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            visited = new boolean[N][N];
            queue = new ArrayDeque<>();

            for (int number : numbers) {
                int x = virus.get(number)[0];
                int y = virus.get(number)[1];
                visited[x][y] = true;
                queue.add(new int[]{x, y, 0});
            }
            bfs();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            numbers[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    static void bfs() {
        int time = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int ndepth = cur[2] + 1;

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if (map[nx][ny] == 1) continue;
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, ndepth});
                        time = Math.max(ndepth, time);
                    }

                    if (map[nx][ny] == 2) {
                        visited[nx][ny] = true;
                        if (check()) {
                            result = Math.min(result, time);
                            return;
                        }
                        queue.add(new int[]{nx, ny, ndepth});
                        time = Math.max(ndepth, time);
                    }
                }
            }
        }
        if (check()) result = Math.min(result, time);

    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) return false;
            }
        }
        return true;
    }
}