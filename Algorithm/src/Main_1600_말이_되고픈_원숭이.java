import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이_되고픈_원숭이 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int K;
    static int W;
    static int H;
    static int[][] map;
    static boolean[][][] visited = new boolean[201][201][31];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};


    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        bw.close();
    }

    public static void bfs() throws IOException {
        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Monkey m = q.poll();
            if (m.x == H - 1 && m.y == W - 1) {
                bw.write(m.cnt + "\n");
                return;
            }
            if (m.k < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = m.x + hx[i];
                    int ny = m.y + hy[i];
                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (map[nx][ny] == 1) continue;
                    if (visited[nx][ny][m.k + 1]) continue;
                    visited[nx][ny][m.k + 1] = true;
                    q.add(new Monkey(nx, ny, m.k + 1, m.cnt + 1));
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = m.x + dx[i];
                int ny = m.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (map[nx][ny] == 1) continue;
                if (visited[nx][ny][m.k]) continue;
                visited[nx][ny][m.k] = true;
                q.add(new Monkey(nx, ny, m.k, m.cnt + 1));
            }
        }

        bw.write("-1\n");
    }

    static class Monkey {
        int x;
        int y;
        int k;
        int cnt;

        public Monkey(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}