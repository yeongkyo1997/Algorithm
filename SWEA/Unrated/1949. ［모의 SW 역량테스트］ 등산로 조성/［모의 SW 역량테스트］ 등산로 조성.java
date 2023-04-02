import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K; // 지도의 크기, 최대 공사 가능 깊이
    static int[][] map; // 지도
    static boolean[][] visited; // 방문 여부
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우
    static int max = 0; // 최대 등산로 길이
    static int max_height = 0; // 최대 높이

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            max = 0; // 최대 등산로 길이 초기화
            max_height = 0; // 최대 높이 초기화

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > max_height) max_height = map[i][j]; // 최대 높이 갱신
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max_height) { // 최대 높이에서 시작
                        visited[i][j] = true; // 방문 처리
                        dfs(i, j, 1, false); // 공사 여부에 따라 다음 위치로 이동
                        visited[i][j] = false; // 방문 처리 해제
                    }
                }
            }

            bw.write("#" + t + " " + max + "\n");
        }
        bw.close();
    }

    /*
     * x, y: 현재 위치
     * cnt: 현재까지의 등산로 길이
     * flag: 공사 여부
     */
    public static void dfs(int x, int y, int cnt, boolean flag) {
        if (max < cnt) max = cnt; // 최대 등산로 길이 갱신

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;

            if (map[nx][ny] < map[x][y]) {
                visited[nx][ny] = true;
                dfs(nx, ny, cnt + 1, flag); // 공사 여부에 따라 다음 위치로 이동
                visited[nx][ny] = false;
            } else {
                if (!flag) { // 공사를 하지 않았다면
                    for (int k = 1; k <= K; k++) { // 최대 공사 가능 깊이만큼 공사
                        if (map[nx][ny] - k < map[x][y]) { // 공사 후 이동 가능한 경우
                            int temp = map[nx][ny]; // 원래 높이 저장
                            map[nx][ny] -= k; // 공사
                            visited[nx][ny] = true; // 방문 처리
                            dfs(nx, ny, cnt + 1, true); // 공사 여부에 따라 다음 위치로 이동
                            visited[nx][ny] = false; // 방문 처리 해제
                            map[nx][ny] = temp; // 원래 높이로 복구
                        }
                    }
                }
            }
        }
    }
}