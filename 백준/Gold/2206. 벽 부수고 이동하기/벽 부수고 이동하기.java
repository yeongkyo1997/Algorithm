import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] board;
    static int[][][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        bw.write(bfs() + "");

        bw.close();
    }

    static int bfs() {
        q = new LinkedList<>();
        visited[0][0][0] = 1;
        q.offer(new int[] { 0, 0, 0 });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], wall = cur[2];

            if (x == N - 1 && y == M - 1)
                return visited[x][y][wall];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (board[nx][ny] == 1 && wall == 0 && visited[nx][ny][1] == 0) {
                    visited[nx][ny][1] = visited[x][y][wall] + 1;
                    q.offer(new int[] { nx, ny, 1 });
                }
                else if (board[nx][ny] == 0 && visited[nx][ny][wall] == 0) {
                    visited[nx][ny][wall] = visited[x][y][wall] + 1;
                    q.offer(new int[] { nx, ny, wall });
                }
            }
        }
        return -1;
    }

}