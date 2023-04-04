package A형_역테_준비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_5648_원자_소멸_시뮬레이션 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N; // T: 테스트케이스, N: 원자의 개수
    static int[][] map = new int[4000 + 100][4000 + 100]; // 좌표를 양수로 변환하기 위해 4000을 더함
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int offset = 2000; // 좌표를 양수로 변환하기 위한 값

    /*
     * r: 행, c: 열, dir: 방향, energy: 에너지
     */
    static class ATOM {
        int r;
        int c;
        int dir;
        int energy;

        public ATOM(int r, int c, int dir, int energy) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.energy = energy;
        }
    }

    static ATOM[] atom = new ATOM[1000 + 100]; // 입력받은 원자들
    static ATOM[] liveAtom = new ATOM[1000 + 100]; // 살아있는 원자들

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();
            bw.write("#" + t + " " + simulate() + "\n");
        }
        bw.flush();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int energy = Integer.parseInt(st.nextToken());

            r = r * 2 + offset; // 좌표를 양수로 변환하기 위해 2를 곱함
            c = c * 2 + offset; // 좌표를 양수로 변환하기 위해 2를 곱함

            atom[i] = new ATOM(r, c, dir, energy);

            map[r][c] = energy;
        }
    }

    static int simulate() {
        int lcnt, tcnt, sum; // lcnt: 살아있는 원자의 개수, tcnt: 살아있는 원자들 중에서 다음 시간에 살아있을 원자들의 개수, sum: 에너지의 합

        lcnt = sum = 0; // 살아있는 원자의 개수와 에너지의 합을 0으로 초기화

        for (int i = 0; i < N; i++) liveAtom[lcnt++] = atom[i]; // 살아있는 원자들을 liveAtom에 복사

        do {
            tcnt = 0; // 살아있는 원자들 중에서 다음 시간에 살아있을 원자들의 개수를 0으로 초기화

            for (int i = 0; i < lcnt; i++) { // 살아있는 원자들을 하나씩 꺼내서 이동시킴
                if (liveAtom[i].energy != map[liveAtom[i].r][liveAtom[i].c]) { // 이미 다른 원자와 충돌한 경우
                    sum += map[liveAtom[i].r][liveAtom[i].c]; // 충돌한 원자들의 에너지를 sum에 더함
                    map[liveAtom[i].r][liveAtom[i].c] = 0; // 충돌한 원자들의 에너지를 0으로 초기화
                    continue;
                }

                int nr, nc;

                nr = liveAtom[i].r + dx[liveAtom[i].dir];
                nc = liveAtom[i].c + dy[liveAtom[i].dir];

                if (nr < 0 || nc < 0 || nr > 4000 || nc > 4000) continue; // 범위를 벗어난 경우

                map[liveAtom[i].r][liveAtom[i].c] = 0; // 이동하기 전에 원자의 위치를 0으로 초기화

                liveAtom[i].r = nr; // 이동한 위치로 원자의 위치를 변경
                liveAtom[i].c = nc; // 이동한 위치로 원자의 위치를 변경

                if (map[nr][nc] == 0) liveAtom[tcnt++] = liveAtom[i]; // 다음 시간에 살아있을 원자들을 liveAtom에 복사

                map[nr][nc] += liveAtom[i].energy; // 이동한 위치에 원자의 에너지를 더함
            }

            lcnt = tcnt; // 살아있는 원자들 중에서 다음 시간에 살아있을 원자들의 개수를 lcnt에 복사

        } while (lcnt != 0); // 살아있는 원자가 없을 때까지 반복

        return sum; // 에너지의 합을 반환
    }
}