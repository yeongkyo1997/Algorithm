import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int maxCnt;
    static int max;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new int[N][N];
            maxCnt = -9999999;
            max = -9999999;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (max < map[i][j]) max = map[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) {
                        visited[i][j] = 1;
                        dfs(i, j, K, 0, 1);
                        visited[i][j] = 0;
                    }
                }
            }
            bw.write("#" + t + " " + maxCnt + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int row, int col, int k, int check, int cnt) {
        for (int i = 0; i < 4; i++) {
            if (0 <= row + dx[i] && row + dx[i] < N && 0 <= col + dy[i] && col + dy[i] < N && map[row][col] > map[row + dx[i]][col + dy[i]] && visited[row + dx[i]][col + dy[i]] == 0) {
                int new_cnt = cnt + 1;
                visited[row + dx[i]][col + dy[i]] = 1;
                dfs(row + dx[i], col + dy[i], k, check, new_cnt);
                visited[row + dx[i]][col + dy[i]] = 0;
            } else if (0 <= row + dx[i] && row + dx[i] < N && 0 <= col + dy[i] && col + dy[i] < N && map[row][col] <= map[row + dx[i]][col + dy[i]] && check == 0 && visited[row + dx[i]][col + dy[i]] == 0) {
                for (int j = 1; j <= k; j++) {
                    map[row + dx[i]][col + dy[i]] -= j;
                    if (map[row][col] > map[row + dx[i]][col + dy[i]]) {
                        visited[row + dx[i]][col + dy[i]] = 1;
                        int new_cnt = cnt + 1;
                        dfs(row + dx[i], col + dy[i], k - j, 1, new_cnt);
                        visited[row + dx[i]][col + dy[i]] = 0;
                    }
                    map[row + dx[i]][col + dy[i]] += j;
                }
            }
        }
        if (maxCnt < cnt) {
            maxCnt = cnt;
        }
    }
}