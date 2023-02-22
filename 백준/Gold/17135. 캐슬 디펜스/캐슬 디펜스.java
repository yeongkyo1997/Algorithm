import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    static class Castle implements Comparable<Castle> {
        int x, y, z;

        public Castle(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Castle(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Castle o) {
            if (this.z == o.z) return this.y - o.y;
            return this.z - o.z;
        }
    }


    static int n, m, d, result;
    static int[][] a = new int[15][15];
    static int[] archer = new int[3];

    static void kill() {
        int[][] b = new int[15][15];
        int cnt = 0, t = n;

        for (int i = 0; i < n; i++) {
            if (m >= 0) System.arraycopy(a[i], 0, b[i], 0, m);
        }
        while (t-- != 0) {
            List<Castle> list = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                PriorityQueue<Castle> pq = new PriorityQueue<>();

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (b[j][k] != 0) {
                            int dist = Math.abs(n - j) + Math.abs(archer[i] - k);
                            if (dist <= d) pq.add(new Castle(j, k, dist));
                        }
                    }
                }

                if (!pq.isEmpty()) {
                    int x = pq.peek().x, y = pq.peek().y;
                    list.add(new Castle(x, y));
                }
            }

            for (Castle castle : list) {
                int x = castle.x, y = castle.y;
                if (b[x][y] != 0) {
                    b[x][y] = 0;
                    cnt += 1;
                }
            }

            for (int i = n - 2; i >= 0; i--) {
                if (m >= 0) System.arraycopy(b[i], 0, b[i + 1], 0, m);
            }

            for (int i = 0; i < m; i++)
                b[0][i] = 0;
        }
        if (result < cnt) result = cnt;
    }

    static void solve() {
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    archer[0] = i;
                    archer[1] = j;
                    archer[2] = k;
                    kill();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        bw.write(result + "\n");
        bw.close();
    }
}