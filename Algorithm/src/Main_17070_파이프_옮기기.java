import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17070_파이프_옮기기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;

    static class Node {
        int x;
        int y;
        int depth;
        int status;

        public Node(int x, int y, int depth, int status) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.status = status;
        }

    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 1, 0, 0));

        int result = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int nx = cur.x + 1;
            int ny = cur.y + 1;
            int ndepth = cur.depth + 1;

            if (cur.x == N - 1 && cur.y == N - 1) {
                result++;
                continue;
            }

            // 가로 0
            if (ny < N && (cur.status == 0 || cur.status == 1)) {
                if (map[cur.x][ny] == 0) {
                    queue.add(new Node(cur.x, ny, ndepth, 0));
                }
            }

            // 세로 2
            if (nx < N) {
                if (map[nx][cur.y] == 0 && (cur.status == 1 || cur.status == 2)) {
                    queue.add(new Node(nx, cur.y, ndepth, 2));
                }
            }

            // 대각선
            if (nx < N && ny < N) {
                if (map[nx][ny] == 0 && map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
                    queue.add(new Node(nx, ny, ndepth, 1));
                }
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
