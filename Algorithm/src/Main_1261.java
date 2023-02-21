import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x, y;
        int wall;

        public Node(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[M][N];
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bw.write(bfs(0, 0) + "");
        bw.close();
    }

    static int bfs(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.wall))); pq.add(new Node(x, y, 0));
        visited[x][y] = visited[x][y] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx == M - 1 && ny == N - 1) {
                    return cur.wall;
                }

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        pq.add(new Node(nx, ny, 0));
                    } else {
                        visited[nx][ny] = true;
                        pq.add(new Node(nx, ny, cur.wall + 1));
                    }
                }
            }
        }
        return 0;
    }
}
