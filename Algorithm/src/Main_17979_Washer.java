import java.util.*;
import java.io.*;

public class Main_17979_Washer {
    static int n, k;
    static int[][] points = new int[101][3];
    static int[] where = new int[100];
    static double[][][] washer = new double[2][2][3];
    static double[] cnt = new double[2];
    static boolean[] visited = new boolean[100];
    static int[] pqr = new int[3];
    static int[] var = new int[3];
    static double result = Double.MAX_VALUE;

    static void push(int i) {
        int washer_num = where[i];
        cnt[washer_num] += 1;
        for (int rgb = 0; rgb < 3; ++rgb) {
            washer[0][washer_num][rgb] += points[i][rgb];
            washer[1][washer_num][rgb] += (points[i][rgb] * points[i][rgb]);
        }
    }

    static void pull(int i) {
        int washer_num = where[i];
        cnt[washer_num] -= 1;
        for (int rgb = 0; rgb < 3; ++rgb) {
            washer[0][washer_num][rgb] -= points[i][rgb];
            washer[1][washer_num][rgb] -= (points[i][rgb] * points[i][rgb]);
        }
    }

    static double calc(int washer_num) {
        double ret = 0.0;
        if (cnt[washer_num] == 0) return ret;
        for (int rgb = 0; rgb < 3; ++rgb) {
            ret += washer[1][washer_num][rgb] - (washer[0][washer_num][rgb] * washer[0][washer_num][rgb] / cnt[washer_num]);
        }
        return ret;
    }

    static void clear() {
        for (int i = 0; i < 2; ++i)
            for (int j = 0; j < 2; ++j)
                for (int m = 0; m < 3; ++m) washer[i][j][m] = 0.0;
        cnt[0] = cnt[1] = 0;
    }

    static void get_vector(int i, int j) {
        for (int m = 0; m < 3; ++m) var[m] = points[j][m] - points[i][m];
    }

    static void get_outer(ArrayList<Integer> i, ArrayList<Integer> j) {
        for (int m = 0; m < 3; ++m)
            var[m] = i.get((m + 1) % 3) * j.get((m + 2) % 3) - i.get((m + 2) % 3) * j.get((m + 1) % 3);
    }

    static void get_where(int who, ArrayList<Integer> h) {
        int ret = 0;
        for (int i = 0; i < 3; ++i) ret += h.get(i) * var[i];
        where[who] = ret > 0 ? 1 : 0;
    }

    static void solve() {
        get_vector(pqr[0], pqr[1]);
        ArrayList<Integer> pq = new ArrayList<>(Arrays.asList(var[0], var[1], var[2]));
        get_vector(pqr[0], pqr[2]);
        ArrayList<Integer> pr = new ArrayList<>(Arrays.asList(var[0], var[1], var[2]));
        get_outer(pq, pr);
        ArrayList<Integer> h = new ArrayList<>(Arrays.asList(var[0], var[1], var[2]));

        clear();
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            get_vector(pqr[0], i);
            get_where(i, h);
            push(i);
        }
        for (int i = 0; i < (1 << 3); ++i) {
            for (int j = 0; j < 3; ++j) {
                where[pqr[j]] = (i & (1 << j)) != 0 ? 1 : 0;
                push(pqr[j]);
            }
            result = Math.min(result, calc(0) + calc(1));
            for (int j = 0; j < 3; ++j) pull(pqr[j]);
        }
    }

    static void dfs(int index, int depth) {
        if (depth == 3) {
            solve();
            return;
        }
        for (int i = index; i < n; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            pqr[depth] = i;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; ++j) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (k == 1) {
            for (int i = 0; i < n; ++i) push(i);
            bw.write(String.format("%.6f\n", calc(0)));
            bw.flush();
            return;
        }
        if (n < 3) {
            bw.write("0.000000\n");
            bw.flush();
            return;
        }
        dfs(0, 0);
        bw.write(String.format("%.6f\n", result));
        bw.flush();
    }
}
