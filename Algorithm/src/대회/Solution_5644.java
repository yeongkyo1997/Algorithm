package 대회;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_5644 {
    static int M, A, result;

    static class User {
        int x, y;

        User(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static User user1, user2;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static int[] path1, path2;

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
            user1 = new User(1, 1);
            user2 = new User(10, 10);

            solve();
            bw.write("#" + (t + 1) + " " + result + "\n");
            result = 0;
        }
        bw.close();
    }

    private static void solve() {
        for (int time = 0; time <= M; time++) {
            user1.x += dx[path1[time]];
            user1.y += dy[path1[time]];
            user2.x += dx[path2[time]];
            user2.y += dy[path2[time]];
            charge();
        }
    }

    private static void charge() {
        int max = 0;
        for (int a = 0; a < A; a++) {
            for (int b = 0; b < A; b++) {
                int aSum = getBCPerformance(a, user1);
                int bSum = getBCPerformance(b, user2);

                max = Math.max(max, (a != b) ? aSum + bSum : Math.max(aSum, bSum));
            }
        }
        result += max;
    }

    private static int getBCPerformance(int idx, User user) {
        return Math.abs(bc[idx].x - user.x) + Math.abs(bc[idx].y - user.y) <= bc[idx].coverage ? bc[idx].performance : 0;
    }
}
