import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    static int maxCon;
    static int minLength;
    static boolean[][] visited;
    private static int result;
    static ArrayList<int[]> cores;
    private static boolean[][] copy;
    private static int curCon;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            visited = new boolean[N][N];
            minLength = Integer.MAX_VALUE;
            maxCon = 0;
            result = 0;
            cores = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if (map[i][j] == 1) {
                        visited[i][j] = true;
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) continue;
                        cores.add(new int[]{i, j});
                    }
                }
            }

            copy = copyVisited(visited);
            dfs(0, 0);
            bw.write(String.format("#%d %d\n", t + 1, result));
            bw.flush();
        }
        bw.close();
    }

    static boolean[][] copyVisited(boolean[][] original) {
        boolean[][] copy = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, N);
        }
        return copy;
    }

    static int check(int x, int y, int dir, boolean[][] copy) {
        int ret = 0;
        if (dir == 0) {
            for (int i = y - 1; i >= 0; i--) {
                if (copy[x][i]) return -1;
                copy[x][i] = true;
                ret++;
            }
        } else if (dir == 1) {
            for (int i = y + 1; i < N; i++) {
                if (copy[x][i]) return -1;
                copy[x][i] = true;
                ret++;
            }
        } else if (dir == 2) {
            for (int i = x - 1; i >= 0; i--) {
                if (copy[i][y]) return -1;
                copy[i][y] = true;
                ret++;
            }
        } else {
            for (int i = x + 1; i < N; i++) {
                if (copy[i][y]) return -1;
                copy[i][y] = true;
                ret++;
            }

        }
        return ret;
    }

    static void dfs(int depth, int length) {
        if (depth <= cores.size()) {
            if (maxCon < curCon) {
                maxCon = curCon;
                minLength = length;
                result = minLength;
            } else if (maxCon == curCon) {
                if (minLength >= length) {
                    minLength = length;
                    result = minLength;
                } else return;
            }
        }

        if (depth == cores.size()) return;
        if (minLength < length) return;

        for (int i = depth; i < cores.size(); i++) {
            for (int j = 0; j < 4; j++) {
                int nx = cores.get(i)[0];
                int ny = cores.get(i)[1];


                boolean[][] prev = copyVisited(copy);
                int curLength = check(nx, ny, j, copy);
                if (curLength == -1) {
                    copy = copyVisited(prev);
                    continue;
                }


                curCon++;
                dfs(depth + 1, length + curLength);
                curCon--;
                copy = copyVisited(prev);
            }
        }
    }
}
