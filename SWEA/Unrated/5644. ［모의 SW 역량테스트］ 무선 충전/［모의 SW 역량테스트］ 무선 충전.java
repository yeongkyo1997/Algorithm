import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int M, A, result; // M: 이동시간, A: BC의 개수

    /*
     * User: 사용자의 위치
     * x: 가로 위치
     * y: 세로 위치
     */
    static class User {
        int x, y;

        User(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static User user1, user2; // 사용자 1, 사용자 2
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static int[] path1, path2;

    /*
     * BC: BC의 정보
     * x: 가로 위치
     * y: 세로 위치
     * coverage: 충전 범위
     * performance: 성능
     */
    static class BC {
        int x, y, coverage, performance;

        BC(int y, int x, int coverage, int performance) {
            this.x = x;
            this.y = y;
            this.coverage = coverage;
            this.performance = performance;
        }

    }

    static BC[] bc;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            path1 = new int[M + 1];
            path2 = new int[M + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                path1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++)
                path2[i] = Integer.parseInt(st.nextToken());

            bc = new BC[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                bc[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            user1 = new User(1, 1); // 사용자 1의 초기 위치
            user2 = new User(10, 10); // 사용자 2의 초기 위치

            solve();
            bw.write("#" + (t + 1) + " " + result + "\n");
            result = 0;
        }
        bw.close();
    }

    private static void solve() {
        // 초기 위치에서 충전
        for (int time = 0; time <= M; time++) {
            user1.x += dx[path1[time]];
            user1.y += dy[path1[time]];
            user2.x += dx[path2[time]];
            user2.y += dy[path2[time]];
            charge(); // 충전
        }
    }

    /*
     * 충전
     * 1. 사용자 1과 사용자 2가 같은 BC에 있을 때
     * 2. 사용자 1과 사용자 2가 다른 BC에 있을 때
     * 3. 사용자 1과 사용자 2가 같은 BC에 있지 않을 때
     */
    private static void charge() {
        int max = 0;

        for (int a = 0; a < A; a++) {
            for (int b = 0; b < A; b++) {
                int aSum = getBCPerformance(a, user1); // 사용자 1이 a번째 BC에 충전할 수 있는 성능
                int bSum = getBCPerformance(b, user2); // 사용자 2가 b번째 BC에 충전할 수 있는 성능

                if (a != b) max = Math.max(max, aSum + bSum); // 사용자 1과 사용자 2가 다른 BC에 있을 때
                else max = Math.max(max, Math.max(aSum, bSum)); // 사용자 1과 사용자 2가 같은 BC에 있을 때
            }
        }
        result += max; // 사용자 1과 사용자 2가 같은 BC에 있지 않을 때
    }

    /*
     * BC에 충전할 수 있는 성능
     * 1. BC의 범위 내에 있을 때
     * 2. BC의 범위 내에 없을 때
     * idx: BC의 인덱스
     * user: 사용자의 위치
     */
    private static int getBCPerformance(int idx, User user) {
        if (Math.abs(bc[idx].x - user.x) + Math.abs(bc[idx].y - user.y) > bc[idx].coverage) return 0; // BC의 범위 내에 없을 때
        else return bc[idx].performance; // BC의 범위 내에 있을 때
    }
}