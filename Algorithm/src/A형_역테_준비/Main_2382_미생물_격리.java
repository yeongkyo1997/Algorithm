package A형_역테_준비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2382_미생물_격리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M, K; // N: 격리시설의 크기, M: 격리시설의 경과시간, K: 미생물 군집의 개수
    static int[][][] map; // 미생물 군집의 정보를 저장할 배열
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int total; // 격리시설에 남아있는 미생물 군집의 총 수
    static Queue<cluster> q = new ArrayDeque<>(); // 미생물 군집의 정보를 저장할 큐

    /*
     * x: 미생물 군집의 x좌표
     * y: 미생물 군집의 y좌표
     * m: 미생물 군집의 수
     */
    static class cluster {
        int x, y, m;

        public cluster(int x, int y, int m) {
            this.x = x;
            this.y = y;
            this.m = m;
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N][3];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                map[x][y][0] = k;
                map[x][y][1] = d;
                q.add(new cluster(x, y, 0));
            }
            total = 0;
            while (!q.isEmpty()) {
                int len = q.size();
                int[][][] copy_map = new int[N][N][3];
                for (int i = 0; i < len; i++) {
                    cluster now = q.poll();
                    int k = map[now.x][now.y][0]; // 미생물 군집의 수
                    int d = map[now.x][now.y][1]; // 미생물 군집의 이동 방향

                    if (now.m == M) {
                        total += map[now.x][now.y][0]; // 격리시설에 남아있는 미생물 군집의 총 수
                        continue;
                    }

                    int nx = now.x + dir[d - 1][0]; // 미생물 군집의 이동할 x좌표
                    int ny = now.y + dir[d - 1][1];  // 미생물 군집의 이동할 y좌표

                    if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) { // 미생물 군집이 격리시설의 경계에 도착한 경우
                        k /= 2; // 미생물 군집의 수를 절반으로 줄임
                        if (k == 0) continue; // 미생물 군집의 수가 0이면 더 이상 이동하지 않음
                        if (d == 1 || d == 3) d++; // 미생물 군집의 이동 방향을 반대로 바꿈
                        else d--; // 미생물 군집의 이동 방향을 반대로 바꿈
                    }

                    if (copy_map[nx][ny][0] == 0) { // 미생물 군집이 이동할 위치에 미생물 군집이 없는 경우
                        copy_map[nx][ny][0] = k; // 미생물 군집의 수를 이동할 위치에 저장
                        copy_map[nx][ny][1] = d; // 미생물 군집의 이동 방향을 이동할 위치에 저장
                        q.add(new cluster(nx, ny, now.m + 1)); // 미생물 군집의 정보를 큐에 저장
                    } else {    // 미생물 군집이 이동할 위치에 미생물 군집이 있는 경우
                        if (copy_map[nx][ny][2] == 0)
                            copy_map[nx][ny][2] = copy_map[nx][ny][0];    // 미생물 군집이 이동할 위치에 미생물 군집이 있는 경우

                        if (copy_map[nx][ny][2] < k) { // 이동할 위치에 있는 미생물 군집의 수가 더 작은 경우
                            copy_map[nx][ny][2] = k; // 미생물 군집의 수를 이동할 위치에 저장
                            copy_map[nx][ny][1] = d; // 미생물 군집의 이동 방향을 이동할 위치에 저장
                        }
                        copy_map[nx][ny][0] += k; // 미생물 군집의 수를 이동할 위치에 저장
                    }
                }
                map = copy_map; // 미생물 군집의 정보를 저장할 배열을 갱신
            }
            bw.write("#" + t + " " + total + "\n");
        }
        bw.flush();
        bw.close();
    }
}
