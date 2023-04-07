import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] arr;
    static int N, M;
    static boolean[][] visited;
    static List<int[]> list = new ArrayList<>();
    static List<int[]> virus = new ArrayList<>();
    static int[] numbers = new int[3];
    static Queue<int[]> queue = new ArrayDeque<>();
    static int result = 0;
    static int[][] copy;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) list.add(new int[]{i, j});
                if (arr[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        dfs(0, 0);
        bw.write(String.valueOf(result));
        bw.close();
    }

    static void dfs(int start, int depth) {
        if (depth == 3) {
            mapCopy();

            for (int i = 0; i < 3; i++) {
                int x = list.get(numbers[i])[0];
                int y = list.get(numbers[i])[1];
                copy[x][y] = 1;
            }
            bfs();
            return;
        }

        for (int i = start; i < list.size(); i++) {
            numbers[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    static void bfs() {
        queue.addAll(virus);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        result = Math.max(result, check());
    }

    static int check() {
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) res++;
            }
        }
        return res;
    }

    static void mapCopy() {
        copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(arr[i], 0, copy[i], 0, M);
        }
    }
}