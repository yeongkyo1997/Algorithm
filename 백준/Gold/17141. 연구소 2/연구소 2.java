import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans, cnt;
    static int[] numbers;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q = new ArrayDeque<>();
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        map = new int[N][N];
        numbers = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2) {
                    map[i][j] = 0;
                    list.add(new int[]{i, j, 0});
                    cnt++;
                } else {
                    map[i][j] = tmp;
                }
            }

        }
        comb(0, 0);
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    private static void comb(int idx, int start) {
        if (idx == M) {
            visited = new boolean[N][N];
            for (int x : numbers) {
                int[] pos = list.get(x);
                visited[pos[0]][pos[1]] = true;
                q.offer(new int[]{pos[0], pos[1], 0});
            }

            bfs();
            return;
        }
        for (int i = start; i < cnt; i++) {
            numbers[idx] = i;
            comb(idx + 1, i + 1);
        }
    }

    private static void bfs() {
        int virus = 0;
        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = pos[0] + dx[d];
                int ny = pos[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;
                visited[nx][ny] = true;

                q.offer(new int[]{nx, ny, pos[2] + 1});

                virus = Math.max(virus, pos[2] + 1);
            }
        }
        if (check()) ans = Math.min(ans, virus);
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 1 && !visited[i][j]) return false;
            }
        }
        return true;
    }
}