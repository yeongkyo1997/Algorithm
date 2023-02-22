import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map = new int[1600][1600];
    static int[][] visited = new int[1600][1600];
    static int a, b, sx, sy;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}};

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        makeMap();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sx, sy));
        visited[sx][sy] = -1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (map[pair.x][pair.y] == b) {
                int x = pair.x;
                int y = pair.y;
                Stack<Integer> tracking = new Stack<>();
                while (true) {
                    tracking.push(map[x][y]);
                    if (visited[x][y] == -1)
                        break;
                    for (int i = 0; i < 6; i++) {
                        int nx = x + dir[i][0];
                        int ny = y + dir[i][1];
                        if (map[nx][ny] == visited[x][y]) {
                            x = nx;
                            y = ny;
                            break;
                        }
                    }
                }
                while (!tracking.isEmpty()) {
                    bw.write(tracking.pop() + " ");
                }
                bw.write("\n");
                bw.flush();
            }
            for (int i = 0; i < 6; i++) {
                int nx = pair.x + dir[i][0];
                int ny = pair.y + dir[i][1];
                if (map[nx][ny] == 0 || visited[nx][ny] != 0)
                    continue;
                visited[nx][ny] = map[pair.x][pair.y];
                queue.add(new Pair(nx, ny));
            }
        }

        bw.flush();
        bw.close();
    }

    static void makeMap() {
        int x = 800;
        int y = 800;
        int N = 1;
        int K = 1;

        map[x][y] = 1;
        while (true) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < (i == 1 ? K - 1 : K); j++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    map[nx][ny] = ++N;

                    if (N == a) {
                        sx = nx;
                        sy = ny;
                    }
                    if (N == 1000000)
                        return;
                    x = nx;
                    y = ny;
                }
            }
            K++;
        }
    }
}
