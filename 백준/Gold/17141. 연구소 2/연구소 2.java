import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int N, M;
    static int[][] copy;
    static int[] numbers;
    static List<int[]> virus = new ArrayList<>();
    static Queue<int[]> queue = new ArrayDeque<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        numbers = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    virus.add(new int[]{i, j});
                    map[i][j] = 0;
                } else map[i][j] = num;
            }
        }

        dfs(0, 0);
        if (result == Integer.MAX_VALUE) result = -1;
        bw.write(String.valueOf(result));
        bw.close();
    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            mapCopy();

            for (int number : numbers) {
                int x = virus.get(number)[0];
                int y = virus.get(number)[1];
                queue.add(new int[]{x, y, 0});
                copy[x][y] = 2;
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

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    queue.add(new int[]{nx, ny, ndepth});
                    time = Math.max(ndepth, time);
                }
            }
        }
        if (check()) result = Math.min(time, result);
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copy[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void mapCopy() {
        copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, N);
        }
    }
}