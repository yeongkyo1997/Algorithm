import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    private static int n;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bw.write(String.valueOf(visited[n - 1][n - 1]));
        bw.close();
    }

    static void bfs(int x, int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        pq.add(new int[]{x, y, 0});
        visited[x][y] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCnt = cur[2];

            if (curCnt > visited[curX][curY]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;


                int nextCnt = curCnt;

                if (board[nx][ny] == 0) {
                    nextCnt++;
                }

                if (nextCnt < visited[nx][ny]) {
                    visited[nx][ny] = nextCnt;
                    pq.add(new int[]{nx, ny, nextCnt});
                }
            }
        }
    }
}