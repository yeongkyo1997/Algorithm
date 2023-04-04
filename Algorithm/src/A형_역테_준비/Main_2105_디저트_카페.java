package A형_역테_준비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2105_디저트_카페 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N; // 지도의 크기
    static int[][] cafe; // 디저트 카페 정보
    static int[][] dxy = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}}; // 우하, 좌하, 좌상, 우상
    static int cnt; // 디저트 카페의 종류 수
    static int i, j; // 시작점

    /*
     * x, y: 현재 카페 좌표
     * path: 이전까지 이동한 카페 번호
     * way: 현재 이동 방향
     *
     * 1. 우하, 좌하, 좌상 순서로 이동하고 시작점으로 돌아오면 종료
     * 2. 지도 범위 내에 있고, 중복된 디저트 카페가 아니면
     * 3. 이전 경로에 현재 카페 번호 추가
     * 4. 다음 카페로 이동
     */
    static void dfs(int x, int y, int[] path, int way) {
        if (way == 3 && x == i && y == j && path.length > 2) { // 우하, 좌하, 좌상 순서로 이동하고 시작점으로 돌아오면 종료
            cnt = Math.max(cnt, path.length); // 디저트 카페의 종류 수 최대값 갱신
            return;
        }

        if (0 <= x && x < N && 0 <= y && y < N && !isIn(path, cafe[x][y])) { // 지도 범위 내에 있고, 중복된 디저트 카페가 아니면
            int[] new_path = new int[path.length + 1]; // 이전 경로에 현재 카페 번호 추가
            System.arraycopy(path, 0, new_path, 0, path.length); // 이전 경로 복사
            new_path[path.length] = cafe[x][y]; // 현재 카페 번호 추가


            int nx = x + dxy[way][0]; // 다음 카페 좌표
            int ny = y + dxy[way][1]; // 다음 카페 좌표
            dfs(nx, ny, new_path, way); // 다음 카페로 이동


            if (way < 3) { // 우하, 좌하, 좌상 순서로 이동
                nx = x + dxy[way + 1][0]; // 다음 카페 좌표
                ny = y + dxy[way + 1][1]; // 다음 카페 좌표
                dfs(nx, ny, new_path, way + 1); // 다음 카페로 이동
            }
        }
    }

    static boolean isIn(int[] arr, int num) { // 배열에 해당 숫자가 있는지 확인
        for (int k : arr) { // 배열 순회
            if (k == num) { // 해당 숫자가 있으면
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            cafe = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cafe[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cnt = -1; // 디저트 카페의 종류 수
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    dfs(i, j, new int[0], 0); // 시작점부터 dfs 탐색
                }
            }

            bw.write("#" + t + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
