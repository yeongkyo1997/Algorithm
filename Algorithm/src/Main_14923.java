import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14923 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    private static int N;
    private static int M;
    private static int[][] map;
    private static int Ex;
    private static int Ey;

    static class Node {
        int x, y;
        int depth;
        boolean wall;

        public Node(int x, int y, int depth, boolean wall) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][2];
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int Hx = Integer.parseInt(st.nextToken());
        int Hy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken());
        Ey = Integer.parseInt(st.nextToken());

        bw.write(bfs(Hx, Hy) + "\n");
        bw.close();
    }

    static int bfs(int y, int x) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y, 0, false));
        visited[x][y][0] = true;
        visited[x][y][1] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == Ex - 1 && cur.y == Ey - 1) return cur.depth;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int ndepth = cur.depth + 1;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) {
                        if (cur.wall) {
                            if (visited[nx][ny][1]) continue;
                            visited[nx][ny][1] = true;
                        } else {
                            if (visited[nx][ny][0]) continue;
                            visited[nx][ny][0] = true;
                        }
                        queue.add(new Node(nx, ny, ndepth, cur.wall));
                    } else {
                        if (!cur.wall) {
                            if (visited[nx][ny][1]) continue;
                            visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, ndepth, true));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
