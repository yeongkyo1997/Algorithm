package A형_역테_준비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1949_등산로_조성 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K; // 지도 크기, 최대 공사 가능 깊이
    static int[][] map; // 지도
    static int[][] visited; // 방문 여부
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int maxCnt; // 최대 등산로 길이
    static int max; // 최대 높이

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
                    if (max < map[i][j]) max = map[i][j]; // 최대 높이 찾기
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) { // 최대 높이인 곳에서 시작
                        visited[i][j] = 1; // 방문 표시
                        dfs(i, j, K, 0, 1);
                        visited[i][j] = 0; // 방문 표시 해제
                    }
                }
            }
            bw.write("#" + t + " " + maxCnt + "\n");
        }
        bw.flush();
        bw.close();
    }

    /*
     * row, col : 현재 위치
     * k : 최대 공사 가능 깊이
     * check : 공사 여부
     * cnt : 등산로 길이
     * 1. 현재 위치에서 4방향 탐색
     * 2. 다음 위치가 지도 내에 있고, 현재 위치보다 낮고, 방문하지 않았다면
     * 3. 다음 위치로 이동
     * 4. 등산로 길이 증가
     * 5. 방문 표시
     * 6. dfs
     * 7. 방문 표시 해제
     * 8. 등산로 길이 감소
     * 9. 공사 여부가 0이고, 최대 공사 가능 깊이가 0이 아니라면
     * 10. 현재 위치의 높이를 1 감소
     * 11. 다음 위치로 이동
     * 12. 등산로 길이 증가
     * 13. 방문 표시
     */
    public static void dfs(int row, int col, int k, int check, int cnt) {
        for (int i = 0; i < 4; i++) {
            // 다음 위치가 지도 내에 있고, 현재 위치보다 낮고, 방문하지 않았다면
            if (0 <= row + dx[i] && row + dx[i] < N && 0 <= col + dy[i] && col + dy[i] < N && map[row][col] > map[row + dx[i]][col + dy[i]] && visited[row + dx[i]][col + dy[i]] == 0) {
                int new_cnt = cnt + 1; // 등산로 길이 증가
                visited[row + dx[i]][col + dy[i]] = 1; // 방문 표시
                dfs(row + dx[i], col + dy[i], k, check, new_cnt);  // 다음 위치로 이동
                visited[row + dx[i]][col + dy[i]] = 0; // 방문 표시 해제

                // 다음 위치가 지도 내에 있고, 현재 위치보다 낮거나 같고, 방문하지 않았고, 공사를 하지 않았다면
            } else if (0 <= row + dx[i] && row + dx[i] < N && 0 <= col + dy[i] && col + dy[i] < N && map[row][col] <= map[row + dx[i]][col + dy[i]] && check == 0 && visited[row + dx[i]][col + dy[i]] == 0) {
                for (int j = 1; j <= k; j++) { // 최대 공사 가능 깊이만큼 반복
                    map[row + dx[i]][col + dy[i]] -= j; // 공사
                    if (map[row][col] > map[row + dx[i]][col + dy[i]]) { // 공사 후 현재 위치보다 낮아졌다면
                        visited[row + dx[i]][col + dy[i]] = 1; // 방문 표시
                        int new_cnt = cnt + 1; // 등산로 길이 증가
                        dfs(row + dx[i], col + dy[i], k - j, 1, new_cnt); // 다음 위치로 이동
                        visited[row + dx[i]][col + dy[i]] = 0; // 방문 표시 해제
                    }
                    map[row + dx[i]][col + dy[i]] += j; // 공사 해제
                }
            }
        }
        if (maxCnt < cnt) { // 최대 등산로 길이 갱신
            maxCnt = cnt;
        }
    }
}