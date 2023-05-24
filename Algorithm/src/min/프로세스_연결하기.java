package min;

import java.io.*;
import java.util.StringTokenizer;

public class 프로세스_연결하기 {
    static int N, R, ans, size; // N: 맵 크기, R: 선택된 프로세스 수, ans: 최소값, size: 전체 프로세스 수
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, data; // map: 전체 맵, data: 프로세스의 좌표
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N]; // 전체 맵
            data = new int[12][2];
            visited = new boolean[12];
            ans = Integer.MAX_VALUE; // 최소값
            size = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (map[i][j] == 1) {
                        data[size++] = new int[]{i, j}; // 프로세스의 좌표 저장
                    }
                }
            }
            for (int i = size; i >= 0; i--) {
                R = i; // 선택할 프로세스의 개수
                comb(0, 0); // 선택할 수 있는 프로세스의 개수 중 R개를 선택
                if (ans < Integer.MAX_VALUE) break; // 최소값이 나오면 더이상 탐색할 필요가 없음
            }
            System.out.println("#" + t + " " + ans);
        }
    }

    private static void comb(int cnt, int start) {
        if (cnt == R) { // R개의 프로세스를 선택했으면
            dfs(0, 0);
            return;
        }
        for (int i = start; i < size; i++) { // 프로세스 선택
            visited[i] = true;
            comb(cnt + 1, i + 1);
            visited[i] = false;
        }
    }

    private static void dfs(int cnt, int sum) {
        if (cnt == size) { // 모든 프로세스를 다 선택했으면
            ans = Math.min(ans, sum);
            return;
        }
        if (!visited[cnt]) { // 프로세스를 선택하지 않았으면
            dfs(cnt + 1, sum);
            return;
        }
        for (int d = 0; d < 4; d++) { // 4방향으로 탐색
            int tmp = 0;
            int nx = data[cnt][0];
            int ny = data[cnt][1];
            boolean ck = false;

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    ck = true;
                    break;
                }

                if (map[nx][ny] != 0) break; // 다른 프로세스를 만나면
                map[nx][ny] = 2; // 경로 표시
                tmp++;
            }
            if (ck) dfs(cnt + 1, sum + tmp); // 경로가 끝까지 이어졌으면 다음 프로세스 탐색
            while (true) {
                nx -= dx[d];
                ny -= dy[d];
                if (nx == data[cnt][0] && ny == data[cnt][1]) break; // 원래 위치로 돌아왔으면
                map[nx][ny] = 0; // 경로 표시 제거
            }
        }
    }
}