import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans = Integer.MAX_VALUE;
    static int[][] office;
    static ArrayList<Camera> cameras = new ArrayList<>();

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int[][][] directions = {
            {},
            { { 0 }, { 1 }, { 2 }, { 3 } },
            { { 0, 2 }, { 1, 3 } },
            { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } },
            { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } },
            { { 0, 1, 2, 3 } }
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cameras.add(new Camera(i, j, office[i][j]));
                }
            }
        }

        dfs(0, office);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx, int[][] board) {
        if (idx == cameras.size()) {
            int cnt = countBlindSpots(board);
            ans = Math.min(ans, cnt);
            return;
        }

        Camera cam = cameras.get(idx);
        int type = cam.type;

        for (int[] dirs : directions[type]) {
            int[][] copy = copyBoard(board);

            for (int d : dirs) {
                mark(copy, cam.x, cam.y, d);
            }
            dfs(idx + 1, copy);
        }
    }

    static int countBlindSpots(int[][] board) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0)
                    count++;
            }
        }
        return count;
    }

    static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }

    static void mark(int[][] board, int x, int y, int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        while (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 6) {

            if (board[nx][ny] == 0) {
                board[nx][ny] = -1;
            }

            nx += dx[d];
            ny += dy[d];
        }
    }

    static class Camera {
        int x, y, type;

        public Camera(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}