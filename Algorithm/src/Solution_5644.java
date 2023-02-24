import java.io.*;
import java.util.StringTokenizer;

public class Solution_5644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int M, A;
    static int[] path1, path2;
    static User user1, user2;

    static class User {
        int x, y;

        public User(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int result;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    static class BC {
        int x, y, c, p;

        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }

    static BC[] bc;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            path1 = new int[M];
            path2 = new int[M];
            bc = new BC[A];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                path1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                path2[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bc[i] = new BC(x, y, c, p);
            }
            solve();
            bw.write(String.format("#%d %d\n", t + 1, result));

        }
        bw.close();
    }

    static void solve() {
        user1 = new User(1, 1);
        user2 = new User(10, 10);
        result = 0;

        for (int i = 0; i < M; i++) {
            user1.x += dx[path1[i]];
            user1.y += dy[path1[i]];
            user2.x += dx[path2[i]];
            user2.y += dy[path2[i]];
            plusCharge();
        }
    }

    static void plusCharge() {
        int max = 0;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                int a = getBCPerform(i, user1);
                int b = getBCPerform(j, user2);

                max = Math.max(max, (i != j) ? a + b : Math.max(a, b));
            }
        }
        result += max;
    }

    static int getBCPerform(int idx, User user) {
        return Math.abs(user.x - bc[idx].x) + Math.abs(user.y - bc[idx].y) <= bc[idx].c ? bc[idx].p : 0;
    }
}
