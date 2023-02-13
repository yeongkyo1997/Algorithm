import java.io.*;
import java.util.*;

public class Main_1031 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] f, c = new int[103][103];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int tFlow;

    static void flow() {
        int S = 0;
        int E = N + M + 1;

        while (true) {
            ArrayList<Integer> pre = new ArrayList<>(Collections.nCopies(N + M + 2, -1));
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(S);

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : graph.get(cur)) {
                    if (c[cur][next] > f[cur][next] && pre.get(next) == -1) {
                        queue.add(next);
                        pre.set(next, cur);

                        if (next == E) break;
                    }
                }
            }

            if (pre.get(E) == -1) return;

            int flow = 1;

            for (int i = E; i != S; i = pre.get(i)) {
                f[pre.get(i)][i] += flow;
                f[i][pre.get(i)] -= flow;
            }
            tFlow += flow;
        }
    }

    static void flipping(int i, int j) {
        int S = 0;
        int E = N + M + 1;

        f[S][i]--;
        f[i][S]++;
        f[i][j]--;
        f[j][i]++;
        f[j][E]--;
        f[E][j]++;

        Queue<Integer> Q = new ArrayDeque<>();

        Q.add(i);

        List<Integer> prev = new ArrayList<>(Collections.nCopies(N + M + 2, -1));
        prev.set(i, S);

        while (!Q.isEmpty()) {
            int cur = Q.poll();

            for (int next : graph.get(cur)) {
                if (cur == i && next <= j) continue;

                if (next <= i) continue;

                if (c[cur][next] > f[cur][next] && prev.get(next) == -1) {
                    Q.add(next);
                    prev.set(next, cur);

                    if (next == E) break;
                }
            }
        }

        if (prev.get(E) == -1) {
            f[S][i]++;
            f[i][S]--;
            f[i][j]++;
            f[j][i]--;
            f[j][E]++;
            f[E][j]--;

            return;
        }
        int flow = 1;
        for (int k = E; k != S; k = prev.get(k)) {
            f[prev.get(k)][k] += flow;
            f[i][prev.get(k)] -= flow;
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int tmp1 = 0, tmp2 = 0;

        for (int i = 0; i < 103; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(0).add(i);
            graph.get(i).add(0);
            c[0][i] = Integer.parseInt(st.nextToken());
            tmp1 += c[0][i];
        }

        for (int i = N + 1; i < N + M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(i).add(N + M + 1);
            graph.get(N + M + 1).add(i);

            c[i][N + M + 1] = Integer.parseInt(st.nextToken());
            tmp2 += c[i][N + M + 1];
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = N + 1; j < N + M + 1; j++) {
                graph.get(i).add(j);
                graph.get(j).add(i);
                c[i][j] = 1;
            }
        }
        if (tmp1 != tmp2) {
            bw.write("-1");
            return;
        }
        flow();

        if (tFlow != tmp1) {
            bw.write(-1 + "");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = N + 1; j < N + M + 1; j++) {
                if (f[i][j] == 1) flipping(i, j);
                bw.write(f[i][j] + "");
            }
            bw.write("\n" + "");
        }
        bw.close();
    }
}
