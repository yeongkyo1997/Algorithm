import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16933 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int M;
    private static int N;
    private static int K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x, y, depth, wall;
        boolean isNight;

        public Node(int x, int y, int depth, int wall, boolean isNight) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.wall = wall;
            this.isNight = isNight;
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
        queue.add(new Node(0, 0, 0, 0, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == N - 1 && cur.y == M - 1) return cur.depth;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N - 1 && ny >= 0 && ny < M - 1) {
                    if (map[nx][ny] == 0) {
                        if (!visited[nx][ny][cur.wall]) {
                            visited[nx][ny][cur.wall] = true;
                            queue.add(new Node(nx, ny, cur.depth + 1, cur.wall, !cur.isNight));
                        }
                    } else {
                        if (cur.wall < K && !visited[nx][ny][cur.wall + 1]) {
                            if (!cur.isNight) {
                                visited[nx][ny][cur.wall + 1] = true;
                                queue.add(new Node(nx, ny, cur.depth + 1, cur.wall + 1, !cur.isNight));
                            } else {
                                visited[nx][ny][cur.wall + 1] = true;
                                queue.add(new Node(nx, ny, cur.depth + 1, cur.wall, !cur.isNight));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
