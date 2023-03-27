import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] visited;
    static int[][] map;
    static int N, M;

//    static class Node {
//        int x, y;
//        int depth;
//
//        public Node(int x, int y, int depth) {
//            this.x = x;
//            this.y = y;
//            this.depth = depth;
//        }
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bw.write(bfs(0, 0) + "\n");
        bw.close();
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) return visited[N - 1][M - 1] + 1;


            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int ndepth = visited[cur[0]][cur[1]] + 1;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] != 0 || map[nx][ny] != 1) continue;
                visited[nx][ny] = ndepth;
                queue.add(new int[]{nx, ny});
            }
        }
        return -1;
    }
}


