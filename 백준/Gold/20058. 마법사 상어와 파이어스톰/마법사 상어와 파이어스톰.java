import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        int[][] grid = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] Ls = new int[Q];
        for (int i = 0; i < Q; i++) {
            Ls[i] = Integer.parseInt(st.nextToken());
        }

        for (int q = 0; q < Q; q++) {
            int L = Ls[q];
            int blockSize = (int) Math.pow(2, L);

            grid = rotateGrid(grid, blockSize);

            grid = meltIce(grid);
        }

        int totalIce = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                totalIce += grid[i][j];
            }
        }

        int largestBlock = findLargestIceBlock(grid);

        bw.write(totalIce + "\n" + largestBlock + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[][] rotateGrid(int[][] grid, int blockSize) {
        int n = grid.length;
        int[][] newGrid = new int[n][n];

        if (blockSize == 1) {
            for (int i = 0; i < n; i++) {
                System.arraycopy(grid[i], 0, newGrid[i], 0, n);
            }
            return newGrid;
        }

        for (int r = 0; r < n; r += blockSize) {
            for (int c = 0; c < n; c += blockSize) {

                for (int i = 0; i < blockSize; i++) {
                    for (int j = 0; j < blockSize; j++) {
                        newGrid[r + j][c + blockSize - 1 - i] = grid[r + i][c + j];
                    }
                }
            }
        }

        return newGrid;
    }

    public static int[][] meltIce(int[][] grid) {
        int n = grid.length;

        boolean[][] melt = new boolean[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] <= 0)
                    continue;

                int count = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] > 0)
                            count++;
                    }
                }
                if (count < 3) {
                    melt[r][c] = true;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (melt[r][c] && grid[r][c] > 0) {
                    grid[r][c]--;
                }
            }
        }
        return grid;
    }

    public static int findLargestIceBlock(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int largest = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c] && grid[r][c] > 0) {
                    int count = bfs(grid, visited, r, c);
                    largest = Math.max(largest, count);
                }
            }
        }
        return largest;
    }

    public static int bfs(int[][] grid, boolean[][] visited, int startR, int startC) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startR, startC });
        visited[startR][startC] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!visited[nr][nc] && grid[nr][nc] > 0) {
                        visited[nr][nc] = true;
                        queue.offer(new int[] { nr, nc });
                        count++;
                    }
                }
            }
        }
        return count;
    }
}