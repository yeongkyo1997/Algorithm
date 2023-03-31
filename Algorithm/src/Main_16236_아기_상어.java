import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기_상어 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] sea;
    static Shark shark;
    static Fish[] fishs;
    static int ans = 0;
    static boolean notMove = false;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Shark {
        int r, c;
        int size = 2;
        int cnt = 0;
    }

    static class Fish {
        int r, c;
        int size;
    }

    static void initTargetDist(int[][] dist) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = 0;
            }
        }
    }

    static void calcDist(int[][] targetDist) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(shark.r, shark.c));
        targetDist[shark.r][shark.c] = 1;
        while (!q.isEmpty()) {
            int curR = q.peek().r;
            int curC = q.peek().c;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) continue;
                if (targetDist[nr][nc] != 0) continue;
                if (sea[nr][nc] > shark.size) continue;
                q.add(new Pair(nr, nc));
                targetDist[nr][nc] = targetDist[curR][curC] + 1;
            }
        }
    }

    static void eatFishs() {
        int[][] targetDist = new int[20][20];
        initTargetDist(targetDist);
        calcDist(targetDist);
        int fishNum = -1;
        int finaldist = 10000;
        for (int i = 0; i < fishs.length; i++) {
            if (fishs[i].size == -1) continue;
            if (fishs[i].size < shark.size) {
                int dist = targetDist[fishs[i].r][fishs[i].c];
                if (dist == 0) continue;
                if (finaldist > dist) {
                    finaldist = dist;
                    fishNum = i;
                }
            }
        }
        if (finaldist == 10000) {
            notMove = true;
            return;
        }
        ans += (finaldist - 1);
        shark.r = fishs[fishNum].r;
        shark.c = fishs[fishNum].c;
        shark.cnt++;
        if (shark.cnt == shark.size) {
            shark.size++;
            shark.cnt = 0;
        }
        fishs[fishNum].size = -1;
        sea[shark.r][shark.c] = 0;
    }

    static boolean checkingFishEat() {
        for (int i = 0; i < fishs.length; i++) {
            if (fishs[i].size > 0) {
                if (fishs[i].size - shark.size >= 0) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        sea = new int[20][20];
        fishs = new Fish[400];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] != 0) {
                    if (sea[i][j] == 9) {
                        shark = new Shark();
                        shark.r = i;
                        shark.c = j;
                        sea[i][j] = 0;
                    } else {
                        Fish fish = new Fish();
                        fish.r = i;
                        fish.c = j;
                        fish.size = sea[i][j];
                        fishs[i * N + j] = fish;
                    }
                }
            }
        }
        while (true) {
            if (checkingFishEat() || notMove) break;
            eatFishs();
        }
        System.out.println(ans);
    }

    static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}