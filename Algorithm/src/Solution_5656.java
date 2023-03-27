import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5656 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int W;
    private static int H;
    private static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] number;
    static int[][] copy;
    static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            result = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            arr = new int[H][W];
            number = new int[N];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            product(0);

            bw.write(result + "\n");
        }
        bw.close();
    }

    static void mapCopy() {
        copy = new int[H][W];
        for (int i = 0; i < H; i++) {
            if (W >= 0) System.arraycopy(arr[i], 0, copy[i], 0, W);
        }
    }

    static int brickCount() {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (copy[i][j] != 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void product(int depth) {
        if (depth == N) {
            mapCopy();

            for (int i : number) {
                for (int j = 0; j < H; j++) {
                    if (copy[j][i] != 0) {
                        bfs(j, i);
                        down();
                        break;
                    }
                }
            }

            result = Math.min(brickCount(), result);
            return;
        }

        for (int i = 0; i < N; i++) {
            number[depth] = i;
            product(depth + 1);
        }
    }

    static void down() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (copy[j][i] != 0) stack.add(arr[j][i]);
            }

            for (int j = H - 1; j >= 0; j--) {
                copy[j][i] = !stack.isEmpty() ? stack.pop() : 0;
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, copy[x][y]});
        copy[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < cur[2]; i++) {
                for (int j = 1; j < 4; j++) {
                    int nx = cur[0] + dx[j] * i;
                    int ny = cur[1] + dy[j] * i;

                    if (nx >= 0 && ny >= 0 && nx < H && ny < W && copy[nx][ny] != 0) {
                        queue.add(new int[]{nx, ny, copy[nx][ny]});
                        copy[nx][ny] = 0;
                    }
                }
            }
        }
    }
}