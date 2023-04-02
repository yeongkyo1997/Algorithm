import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N;
    static int[][] MAP = new int[4000 + 100][4000 + 100];
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int OFFSET = 2000;

    static class ATOM {
        int r;
        int c;
        int dir;
        int energy;
    }

    static ATOM[] atom = new ATOM[1000 + 100];
    static ATOM[] liveAtom = new ATOM[1000 + 100];

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            input();
            bw.write("#" + tc + " " + simulate() + "\n");
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

            r = r * 2 + OFFSET;
            c = c * 2 + OFFSET;

            atom[i] = new ATOM();
            atom[i].r = r;
            atom[i].c = c;
            atom[i].dir = dir;
            atom[i].energy = energy;

            MAP[r][c] = energy;
        }
    }

    static int simulate() {
        int lcnt, tcnt, sum;

        lcnt = sum = 0;

        for (int i = 0; i < N; i++) liveAtom[lcnt++] = atom[i];

        while (true) {
            tcnt = 0;
            for (int i = 0; i < lcnt; i++) {
                if (liveAtom[i].energy != MAP[liveAtom[i].r][liveAtom[i].c]) {
                    sum += MAP[liveAtom[i].r][liveAtom[i].c];
                    MAP[liveAtom[i].r][liveAtom[i].c] = 0;

                    continue;
                }

                int nr, nc;

                nr = liveAtom[i].r + dr[liveAtom[i].dir];
                nc = liveAtom[i].c + dc[liveAtom[i].dir];

                if (nr < 0 || nc < 0 || nr > 4000 || nc > 4000) continue;

                MAP[liveAtom[i].r][liveAtom[i].c] = 0;

                liveAtom[i].r = nr;
                liveAtom[i].c = nc;

                if (MAP[nr][nc] == 0) liveAtom[tcnt++] = liveAtom[i];

                MAP[nr][nc] += liveAtom[i].energy;
            }

            lcnt = tcnt;

            if (lcnt == 0) break;
        }

        return sum;
    }
}