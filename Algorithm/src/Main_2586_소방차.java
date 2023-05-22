import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2586_소방차 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Pair {
        long x, y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = n + m;

        Pair[] a = new Pair[k + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = new Pair(Long.parseLong(st.nextToken()), 0);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            a[i + n] = new Pair(Long.parseLong(st.nextToken()), 1);
        }

        Arrays.sort(a, 1, k + 1, Comparator.comparingLong(p -> p.x));

        int now = k;
        ArrayList<Pair>[] v = new ArrayList[404040];
        for (int i = 0; i < 404040; i++) {
            v[i] = new ArrayList<>();
        }

        for (int i = 1; i <= k; i++) {
            if (a[i].y == 0) {
                v[now++].add(a[i]);
            } else {
                v[--now].add(a[i]);
            }
        }

        long result = 0;
        for (int i = 0; i < 404040; i++) {
            if (!v[i].isEmpty()) {
                long t = 0;
                for (int j = 1; j < v[i].size(); j += 2) {
                    t += Math.abs(v[i].get(j).x - v[i].get(j - 1).x);
                }
                if ((v[i].size() & 1) == 0) {
                    result += t;
                    continue;
                }
                long mn = t;
                for (int j = v[i].size() - 1; j - 2 >= 0; j -= 2) {
                    t += Math.abs(v[i].get(j).x - v[i].get(j - 1).x) - Math.abs(v[i].get(j - 1).x - v[i].get(j - 2).x);
                    mn = Math.min(mn, t);
                }
                result += mn;
            }
        }

        bw.write(result + "\n");
        bw.close();
    }
}
