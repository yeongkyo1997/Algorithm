import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_16236_아기_상어 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[][] map;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int bx, by;
    static int result = 0;
    static int count = 0;
    static int sz = 2;
    static boolean stop = false;
    static boolean eat = false;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    by = i;
                    bx = j;
                    map[i][j] = 0;
                }
            }
        }

        while (!stop) {
            boolean[][] visit = new boolean[n][n];
            bfs(bx, by, visit, sz);
            if (eat) {
                eat = false;
                count += 1;
                map[by][bx] = 0;
                if (count == sz) {
                    sz += 1;
                    count = 0;
                }
            } else {
                stop = true;
            }
        }
        bw.write(result + "\n");
        bw.close();
    }

    static void bfs(int x, int y, boolean[][] visit, int shSize) {
        int temp = 0;
        visit[y][x] = true;
        Queue<Shark> q = new LinkedList<>();
        q.add(new Shark(x, y, 0));
        while (!q.isEmpty()) {
            x = q.peek().x;
            y = q.peek().y;
            int cnt = q.peek().cnt;

            if (map[y][x] > 0 && map[y][x] < shSize && temp == cnt) {
                if (by == y && bx > x || by > y) {
                    by = y;
                    bx = x;
                    continue;
                }
            }
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[ny][nx]) {
                    if (map[ny][nx] <= shSize) {
                        if (map[ny][nx] > 0 && map[ny][nx] < shSize && !eat) {
                            eat = true;
                            bx = nx;
                            by = ny;
                            temp = cnt + 1;
                            result += temp;
                        } else {
                            q.add(new Shark(nx, ny, cnt + 1));
                            visit[ny][nx] = true;
                        }
                    }
                }
            }
        }
    }

    static class Shark {
        int x;
        int y;
        int cnt;

        public Shark(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}