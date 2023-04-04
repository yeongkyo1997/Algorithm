package A형_역테_준비;

import java.util.Scanner;

public class swea_5650_핀볼게임 {
    static Scanner scanner = new Scanner(System.in);
    static int[][] area; // 0: 빈칸, 1~5: 블록, 6~10: 웜홀
    static int[][] block = {{}, {2, 0, 3, 1}, {2, 3, 1, 0}, {1, 3, 0, 2}, {3, 2, 0, 1}, {2, 3, 0, 1}}; // 블록에 따른 방향
    static int[] dx = {0, 1, 0, -1}; // 우하좌상
    static int[] dy = {1, 0, -1, 0};
    static Pair[][] warm; // 웜홀
    static int T, sr, sc, sp; // T: 테스트케이스, sr, sc: 시작점, sp: 시작방향

    static class Pair { // 웜홀 좌표
        int x, c;

        public Pair(int r, int c) {
            this.x = r;
            this.c = c;
        }
    }

    /*
     * r: 행, c: 열, d: 방향
     */
    static int go(int r, int c, int d) {
        if (sr == r && sc == c && sp == 1) return 0; // 시작점으로 돌아오면 종료
        sp = 1; // 시작방향은 1로 초기화

        int ret = 0; // 점수
        int nr = r + dx[d], nc = c + dy[d]; // 다음 좌표
        int num = area[nr][nc]; // 다음 좌표의 블록번호

        if (num != -1) { // 블록이 아니면
            if (num == 0) ret = go(nr, nc, d); // 빈칸이면 그대로 진행
            else if (0 < num && num < 6) {
                ret = go(nr, nc, block[num][d]) + 1; // 블록이면 방향 변경
            } else { // 웜홀이면
                if (warm[0][num].x == nr && warm[0][num].c == nc) ret = go(warm[1][num].x, warm[1][num].c, d); // 다음 좌표가 첫번째 웜홀이면 두번째 웜홀로 이동
                else ret = go(warm[0][num].x, warm[0][num].c, d); // 두번째 웜홀이면 첫번째 웜홀로 이동
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt();
            area = new int[n + 2][n + 2]; // 빈칸을 만들기 위해 2칸씩 더 크게 생성
            warm = new Pair[2][15]; // 웜홀 좌표 저장

            for (int i = 0; i <= n + 1; i++) {
                for (int j = 0; j <= n + 1; j++) {
                    if (i == 0 || j == 0 || i == n + 1 || j == n + 1) area[i][j] = 5; // 빈칸을 만들기 위해 블록번호 5로 초기화
                    else { // 블록번호 입력
                        int num = scanner.nextInt();
                        area[i][j] = num;

                        if (5 < num) { // 웜홀이면
                            if (warm[0][num] == null) warm[0][num] = new Pair(i, j); // 첫번째 웜홀이면
                            else warm[1][num] = new Pair(i, j); // 두번째 웜홀이면
                        }
                    }
                }
            }

            int result = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (area[i][j] == 0) { // 빈칸이면
                        sr = i; // 시작점
                        sc = j;

                        for (int d = 0; d < 4; d++) {
                            sp = 0; // 시작방향
                            result = Math.max(result, go(i, j, d)); // 최대 점수
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", t, result);
        }
    }
}

