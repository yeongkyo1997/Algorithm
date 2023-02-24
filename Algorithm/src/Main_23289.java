import java.io.*;
import java.util.StringTokenizer;

public class Main_23289 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int R, C, K;
    static int[][] room;
    static int[][][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        room = new int[R][C];
        dp = new int[R][C][K + 1];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                max = Math.max(max, dfs(i, j, 0));
            }
        }

        bw.write(max + "");
        bw.close();
    }

    static int dfs(int x, int y, int cnt) {
        if (cnt > K) return 0;
        if (dp[x][y][cnt] != 0) return dp[x][y][cnt];
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (room[nx][ny] == 0) continue;
            max = Math.max(max, dfs(nx, ny, cnt + 1));
        }
        return dp[x][y][cnt] = max + room[x][y];
    }
}
