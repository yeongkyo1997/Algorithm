import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        private int x;
        private int y;
        private int depth;
        private int wall;

        public Node(int x, int y, int depth, int wall) {
            this.setX(x);
            this.setY(y);
            this.setDepth(depth);
            this.setWall(wall);
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public int getWall() {
            return wall;
        }

        public void setWall(int wall) {
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        visited[0][0][0] = visited[0][0][1] = true;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, 0));

        int result = -1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.getX() == N - 1 && cur.getY() == M - 1) {
                result = cur.getDepth();
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];
                int ndepth = cur.getDepth() + 1;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) {
                        if (cur.getWall() > 0) {
                            if (!visited[nx][ny][1]) {
                                visited[nx][ny][1] = true;
                                queue.add(new Node(nx, ny, ndepth, cur.getWall()));
                            }
                        } else if (!visited[nx][ny][0]) {
                            visited[nx][ny][0] = true;
                            queue.add(new Node(nx, ny, ndepth, cur.getWall()));
                        }
                    } else if (cur.getWall() < K) {
                        if (!visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, ndepth, cur.getWall() + 1));
                        }
                    }
                }
            }
        }
        bw.write(result + "");
        bw.close();
    }
}