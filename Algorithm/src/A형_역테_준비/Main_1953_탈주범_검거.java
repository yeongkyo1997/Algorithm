package A형_역테_준비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1953_탈주범_검거 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T, N, M, R, C, L; // 테스트케이스, 세로, 가로, 맨홀 뚜껑 위치, 탈주범이 소요되는 시간
    static int[][] MAP; // 지하 터널 지도
    static int[][] visit; // 탈주범이 지나간 위치를 표시

    static class PIPE {  // 파이프의 형태를 표시
        int up;
        int down;
        int right;
        int left;
    }

    static PIPE[] pipe = new PIPE[8]; // 파이프의 형태를 표시

    static class RC { // 행과 열을 표시
        int r;
        int c;
    }

    static RC[] queue; // 탈주범이 지나간 위치를 저장
    static int rp, wp; // queue의 시작과 끝을 가리키는 포인터

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        MAP = new int[N + 2][M + 2];
        visit = new int[N + 2][M + 2];
        queue = new RC[N * M];

        for (int r = 0; r <= N + 1; r++) {
            for (int c = 0; c <= M + 1; c++) {
                MAP[r][c] = visit[r][c] = 0;
            }
        }

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= M; c++) {
                MAP[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }


    static int isLink(PIPE p1, PIPE p2, int dir) {
        /* p1의 위쪽과, p2의 아래쪽 비교 */
        // if (dir == 1) return p1.up & p2.down;
        // if (dir == 1) return p1.up * p2.down;
        if (dir == 1) return p1.up == 1 && p2.down == 1 ? 1 : 0;

        /* p1의 오른쪽과, p2의 왼쪽 비교 */
        // if (dir == 2) return p1.right & p2.left;
        // if (dir == 2) return p1.right * p2.left;
        if (dir == 2) return p1.right == 1 && p2.left == 1 ? 1 : 0;



        /* p1의 아래쪽과, p2의 위쪽 비교 */
        // if (dir == 3) return p1.down & p2.up;
        // if (dir == 3) return p1.down * p2.up;
        if (dir == 3) return p1.down == 1 && p2.up == 1 ? 1 : 0;


        /* p1의 왼쪽과 p2의 오른쪽 비교 */
        // if (dir == 4) return p1.left & p2.right;
        // if (dir == 4) return p1.left * p2.right;
        if (dir == 4) return p1.left == 1 && p2.right == 1 ? 1 : 0;

        return -1;
    }

    static int[] dr = {0, -1, 0, 1, 0}; // up, right, down, left
    static int[] dc = {0, 0, 1, 0, -1}; // up, right, down, left

    /*
     * 1. 탈주범이 있는 위치를 queue에 넣는다.
     * 2. queue에서 하나를 꺼내서, 상하좌우로 이동할 수 있는지 확인한다.
     * 3. 이동할 수 있다면, queue에 넣는다.
     * 4. 이동할 수 없다면, 다음 queue에서 꺼낸다.
     * 5. L시간이 지나면, 종료한다.
     * 6. visit 배열을 확인하여, 탈주범이 지나간 칸의 수를 센다.
     * 7. 탈주범이 지나간 칸의 수를 출력한다.
     */
    static void bfs(int r, int c) {
        int cnt; // 탈주범이 지나간 칸의 수

        wp = rp = 0; // queue의 시작과 끝을 가리키는 포인터

        queue[wp] = new RC(); // queue에 탈주범이 있는 위치를 넣는다.
        queue[wp].r = r; // queue에 탈주범이 있는 위치를 넣는다.
        queue[wp++].c = c; // queue에 탈주범이 있는 위치를 넣는다.
        visit[r][c] = 1; // 탈주범이 있는 위치를 방문했다고 표시한다.

        cnt = 0; // 탈주범이 지나간 칸의 수

        while (wp > rp) { // queue에 데이터가 없을 때까지 반복한다.
            RC out = queue[rp++]; // queue에서 하나를 꺼낸다.

            for (int i = 1; i <= 4; i++) { // 상하좌우로 이동할 수 있는지 확인한다.
                int nr, nc; // 이동할 위치

                nr = out.r + dr[i]; // 이동할 위치
                nc = out.c + dc[i]; // 이동할 위치

                if (visit[nr][nc] == 0 && MAP[nr][nc] != 0 && isLink(pipe[MAP[out.r][out.c]], pipe[MAP[nr][nc]], i) == 1) {
                    queue[wp] = new RC(); // queue에 탈주범이 있는 위치를 넣는다.
                    queue[wp].r = nr;
                    queue[wp++].c = nc;
                    cnt = visit[nr][nc] = visit[out.r][out.c] + 1; // 탈주범이 있는 위치를 방문했다고 표시한다.
                }
            }

            if (cnt == L + 1) return; // L시간이 지나면, 종료한다.
        }
    }

    /*
     * 탈주범이 지나간 칸의 수를 센다.
     */
    static int checkVisit() {
        int sum = 0; // 탈주범이 지나간 칸의 수

        for (int r = 1; r <= N; r++) { // visit 배열을 확인하여, 탈주범이 지나간 칸의 수를 센다.
            for (int c = 1; c <= M; c++) {
                if (visit[r][c] != 0 && visit[r][c] <= L) sum++; // 탈주범이 지나간 칸의 수를 센다.
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        /* up, down, right, left */
        pipe[1] = new PIPE(); // 1번 파이프
        pipe[1].up = pipe[1].down = pipe[1].right = pipe[1].left = 1;

        pipe[2] = new PIPE(); // 2번 파이프
        pipe[2].up = pipe[2].down = 1;

        pipe[3] = new PIPE(); // 3번 파이프
        pipe[3].right = pipe[3].left = 1;

        pipe[4] = new PIPE(); // 4번 파이프
        pipe[4].up = pipe[4].right = 1;

        pipe[5] = new PIPE(); // 5번 파이프
        pipe[5].down = pipe[5].right = 1;

        pipe[6] = new PIPE(); // 6번 파이프
        pipe[6].down = pipe[6].left = 1;

        pipe[7] = new PIPE(); // 7번 파이프
        pipe[7].up = pipe[7].left = 1;

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int result;

            input();

            bfs(R + 1, C + 1); // 탈주범이 있는 위치를 queue에 넣는다.

            result = checkVisit(); // 탈주범이 지나간 칸의 수를 센다.

            bw.write("#" + tc + " " + result + "\n");
        }
        bw.close();
    }
}
