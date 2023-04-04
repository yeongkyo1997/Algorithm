package A형_역테_준비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_5653_줄기배양세포 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
     * hp: 현재 생명력
     * ahp: 초기 생명력
     * status: 상태
     * 1: 활성화
     * 2: 죽음
     * 3: 비활성화
     * time: 활성화 시간
     */
    static class cell {
        int hp;
        int ahp;
        int status;
        int time;

        public cell(int hp, int ahp, int status, int time) {
            this.hp = hp;
            this.ahp = ahp;
            this.status = status;
            this.time = time;
        }
    }

    static int N, M, K; // 세로, 가로, 시간
    static int time; // 시간
    static cell[][] map1; // 맵
    static int[][] map2; // 입력 맵
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void make_cell(int x, int y, int w, int time) {
        for (int i = 0; i < 4; i++) {
            if (map1[x + dx[i]][y + dy[i]].status == 0) { // 비활성화 상태
                map1[x + dx[i]][y + dy[i]].status = 1; // 활성화
                map1[x + dx[i]][y + dy[i]].hp = w; // 현재 생명력
                map1[x + dx[i]][y + dy[i]].ahp = w; // 초기 생명력
                map1[x + dx[i]][y + dy[i]].time = time; // 활성화 시간
            } else if (map1[x + dx[i]][y + dy[i]].status == 1 && map1[x + dx[i]][y + dy[i]].time == time) { // 활성화 상태
                if (w > map1[x + dx[i]][y + dy[i]].hp) { // 현재 생명력이 더 크면
                    map1[x + dx[i]][y + dy[i]].hp = w; // 현재 생명력
                    map1[x + dx[i]][y + dy[i]].ahp = w; // 초기 생명력
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            time = 0;
            map1 = new cell[N + K][M + K]; // 맵
            map2 = new int[N][M]; // 입력 맵

            for (int i = 0; i < N + K; i++) {
                for (int j = 0; j < M + K; j++) {
                    map1[i][j] = new cell(0, 0, 0, 0); // 초기화
                }
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map2[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int s = K / 2; // 시작점
            for (int i = s; i < s + N; i++) { // 입력 맵을 맵에 복사
                for (int j = s; j < s + M; j++) {
                    if (map2[i - s][j - s] != 0) { // 세포가 있으면
                        map1[i][j].status = 1; // 활성화
                        map1[i][j].hp = map2[i - s][j - s]; // 현재 생명력
                        map1[i][j].ahp = map2[i - s][j - s]; // 초기 생명력
                    }
                }
            }
            while (time < K) { // 시간이 K보다 작으면
                time++; // 시간 증가
                for (int i = 0; i < N + K; i++) { // 맵 탐색
                    for (int j = 0; j < M + K; j++) {
                        if (map1[i][j].status == 1 && map1[i][j].time < time) { // 활성화 상태이고 활성화 시간이 지났으면
                            map1[i][j].hp--; // 현재 생명력 감소
                            if (map1[i][j].hp == 0) { // 현재 생명력이 0이면
                                map1[i][j].status = 2; // 죽음
                                map1[i][j].hp = map1[i][j].ahp; // 현재 생명력 초기화
                            }
                        } else if (map1[i][j].status == 2) { // 죽음 상태이면
                            map1[i][j].hp--; // 현재 생명력 감소
                            if (map1[i][j].hp == map1[i][j].ahp - 1) { // 현재 생명력이 초기 생명력 - 1이면
                                make_cell(i, j, map1[i][j].ahp, time); // 세포 생성
                            }
                            if (map1[i][j].hp == 0) { // 현재 생명력이 0이면
                                map1[i][j].status = 3; // 비활성화
                            }
                        }
                    }
                }
            }

            int cnt = 0; // 활성화 상태의 세포 개수
            for (int i = 0; i < N + K; i++) {
                for (int j = 0; j < M + K; j++) {
                    if (map1[i][j].status == 1 || map1[i][j].status == 2) { // 활성화 상태이거나 죽음 상태이면
                        cnt++;
                    }
                }
            }
            bw.write("#" + t + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
