import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][][][] visited;
    static int[][] map;

    static class Node {
        int x, y;
        int depth;
        int block;
        boolean isNight;

        public Node(int x, int y, int depth, int block, boolean isNight) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.block = block;
            this.isNight = isNight;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][11][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.close();
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, 0, false));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == N - 1 && cur.y == M - 1) return cur.depth;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!cur.isNight) {
                        if (map[nx][ny] == 1) {
                            if (cur.block + 1 <= K) {
                                if (!visited[nx][ny][cur.block + 1][0]) {
                                    visited[nx][ny][cur.block + 1][0] = true;
                                    queue.add(new Node(nx, ny, cur.depth + 1, cur.block + 1, true));
                                }
                            }
                        } else {
                            if (!visited[nx][ny][cur.block][0]) {
                                visited[nx][ny][cur.block][0] = true;
                                queue.add(new Node(nx, ny, cur.depth + 1, cur.block, true));
                            }
                        }
                    } else {
                        if (map[nx][ny] == 1) {
                            if (cur.block + 1 <= K) {
                                if (!visited[nx][ny][cur.block + 1][1]) {
                                    visited[nx][ny][cur.block + 1][1] = true;
                                    queue.add(new Node(cur.x, cur.y, cur.depth + 1, cur.block, false));
                                }
                            }
                        } else {
                            if (!visited[nx][ny][cur.block][1]) {
                                visited[nx][ny][cur.block][1] = true;
                                queue.add(new Node(nx, ny, cur.depth + 1, cur.block, false));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}