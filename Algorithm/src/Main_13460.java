import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static char[][] map;
    static Queue<Node> queue = new ArrayDeque<>();
    static int fx, fy;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean flag = false;

    static class Node {
        int x, y;
        int depth;
        boolean isRed;

        public Node(int x, int y, int depth, boolean isRed) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.isRed = isRed;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'B') queue.add(new Node(i, j, 0, false));
                if (map[i][j] == 'R') {
                    queue.add(new Node(i, j, 0, true));
                }
                if (map[i][j] == 'O') {
                    fx = i;
                    fy = j;
                }
            }
        }
        int result = -1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = getDx(cur.x, cur.y, dx[i]);
                int ny = getDy(cur.x, cur.y, dy[i]);
                int ndepth = cur.depth + 1;

                if (cur.isRed) {
                    if (flag) result = cur.depth;
                }
                if (!cur.isRed) {
                    if (flag) {
                        flag = false;
                        continue;
                    }
                }
                queue.add(new Node(nx, ny, ndepth, cur.isRed));
            }
        }

        bw.write(result + "");
        bw.close();
    }

    static int getDx(int x, int y, int dir) {
        if (dir == 0) return x;

        while (true) {
            int nx = x + dir;
            if (map[nx][y] == '#') break;
            x = nx;
            if (map[x][y] == 'O') {
                flag = true;
                return x;
            }
        }
        return x;
    }

    static int getDy(int x, int y, int dir) {
        if (dir == 0) return y;
        while (true) {
            int ny = y + dir;

            if (map[x][ny] == '#') break;
            y = ny;

            if (map[x][y] == 'O') {
                flag = true;
                return y;
            }
        }
        return y;
    }
}
