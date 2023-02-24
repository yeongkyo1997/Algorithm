import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int N, M, K;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x, y, wall;
        int depth;

        public Node(int x, int y, int wall, int depth) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][11];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bw.write(bfs() + "");
        bw.close();
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 0, 1));
        int result = -1;
        visited[0][0][0] = visited[0][0][1] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == N - 1 && cur.y == M - 1) return cur.depth;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int ndepth = cur.depth + 1;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) {
                        if (cur.wall == 0) {
                            if (!visited[nx][ny][0]) {
                                visited[nx][ny][0] = true;
                                queue.add(new Node(nx, ny, cur.wall, ndepth));
                            }
                        } else {
                            if (!visited[nx][ny][cur.wall]) {
                                visited[nx][ny][cur.wall] = true;
                                queue.add(new Node(nx, ny, cur.wall, ndepth));
                            }
                        }
                    } else {
                        if (cur.wall == K) continue;
                        if (!visited[nx][ny][cur.wall + 1]) {
                            visited[nx][ny][cur.wall + 1] = true;
                            queue.add(new Node(nx, ny, cur.wall + 1, ndepth));
                        }
                    }
                }
            }
        }
        return result;
    }
}