import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int result = 0;
    static int curEat = 0;
    static int sharkSize = 0;
    static int curX, curY;
    private static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class MinPoint implements Comparable<MinPoint> {
        int x, y;
        int size;

        public MinPoint(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public int compareTo(MinPoint o) {
            if (Math.abs(curX - this.x) + Math.abs(curY - this.y) == Math.abs(curX - this.x) + Math.abs(curY - this.y))
                if (this.x == o.x) return this.y - o.y;
            return Math.abs(curX - this.x) + Math.abs(curY - this.y) - Math.abs(curX - this.x) + Math.abs(curY - this.y);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    curX = i;
                    curY = j;
                }
            }
        }
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int ndepth = cur[2] + 1;

//                if ()
            }
        }
        return false;
    }
}