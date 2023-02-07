import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1069 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int x, y, d, t;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        visited = new int[x + 1][y + 1];

        bfs();
        bw.write(visited[x][y] + "");
        bw.flush();
        bw.close();
    }

    static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
        pq.add(new int[] { x, y, 0 });

        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int nx, ny, ndepth;

            for (int i = 0; i < 4; i++) {
                nx = next[0] + dx[i];
                ny = next[1] + dy[i];
                ndepth = next[2] + 1;

                if (nx >= 0 && nx <= x && ny >= 0 && ny <= y) {
                    if (visited[nx][ny] > ndepth || visited[nx][ny] == 0) {
                        visited[nx][ny] = ndepth;
                        pq.add(new int[] { nx, ny, ndepth });
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                nx = next[0] + dx[i] * d;
                ny = next[1] + dy[i] * d;
                ndepth = next[2] * t;

                if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
                    if (visited[nx][ny] > ndepth || visited[nx][ny] == 0) {
                        visited[nx][ny] = ndepth;
                        pq.add(new int[] { nx, ny, ndepth });
                    }
                }
            }
        }
    }
}
