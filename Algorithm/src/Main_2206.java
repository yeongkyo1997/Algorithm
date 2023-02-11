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
        int x, y, depth;
        int wall;

        public Node(int x, int y, int depth, int wall) {
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
            if (cur.x == N - 1 && cur.y == M - 1) {
                result = cur.depth;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int ndepth = cur.depth + 1;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) {
                        if (cur.wall > 0) {
                            if (!visited[nx][ny][1]) {
                                visited[nx][ny][1] = true;
                                queue.add(new Node(nx, ny, ndepth, cur.wall));
                            }
                        } else {
                            if (!visited[nx][ny][0]) {
                                visited[nx][ny][0] = true;
                                queue.add(new Node(nx, ny, ndepth, cur.wall));
                            }
                        }
                    } else {
                        if (cur.wall < K) {
                            if (!visited[nx][ny][1]) {
                                visited[nx][ny][1] = true;
                                queue.add(new Node(nx, ny, ndepth, cur.wall + 1));
                            }
                        }
                    }
                }
            }
        }
        bw.write(result + "");
        bw.close();
    }
}