import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_13361_최고인_대장장이_토르비욘 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static pii[] arr = new pii[1010101];
    static pii[] poi = new pii[1010101];
    static long[] par = new long[1010101];
    static long[] sz = new long[1010101];
    static long[][] gp = new long[1010101][1010101];
    static long[] loc = new long[1010101];

    static long fi(long x) {
        if (x == par[(int) x]) return x;
        return par[(int) x] = fi(par[(int) x]);
    }

    static void uf(long a, long b) {
        a = fi(a);
        b = fi(b);
        if (sz[(int) b] < sz[(int) a]) {
            par[(int) b] = a;
            sz[(int) a] += sz[(int) b];
        } else {
            par[(int) a] = b;
            sz[(int) b] += sz[(int) a];
        }

    }

    public static void main(String[] args) throws Exception {
        long i, j, k, n;
        long result = 0;
        n = Long.parseLong(br.readLine());

        for (i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[(int) i] = new pii(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            poi[(int) i] = new pii(arr[(int) i].ff, i);
            poi[(int) i + (int) n] = new pii(arr[(int) i].ss, i);
            result += arr[(int) i].ff;
            result += arr[(int) i].ss;
            par[(int) i] = i;
            sz[(int) i] = 1;
        }

        for (i = 1; i < poi.length; i++)
            if (poi[(int) i].ff == poi[(int) i - 1].ff && fi(poi[(int) i].ss) != fi(poi[(int) i - 1].ss))
                uf(poi[(int) i].ss, poi[(int) i - 1].ss);

        for (i = 1; i <= n; i++)
            gp[(int) fi(i)][(int) ++gp[(int) fi(i)][0]] = i;

        for (i = 1; i <= n; i++) {
            loc = new long[1010101];
            long cnt = gp[(int) i][0];
            if (cnt == 0) continue;
            for (j = 1; j <= cnt; j++) {
                loc[(int) ++loc[0]] = arr[(int) gp[(int) i][(int) j]].ff;
                loc[(int) ++loc[0]] = arr[(int) gp[(int) i][(int) j]].ss;
            }
            for (j = 1; j <= loc[0]; j++) {
                for (k = j + 1; k <= loc[0]; k++) {
                    if (loc[(int) j] > loc[(int) k]) {
                        long tmp = loc[(int) j];
                        loc[(int) j] = loc[(int) k];
                        loc[(int) k] = tmp;
                    }
                }
            }
            for (j = 1; j <= cnt; j++) {
                result -= loc[(int) j];
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static class pii {
        long ff;
        long ss;

        public pii(long ff, long ss) {
            this.ff = ff;
            this.ss = ss;
        }
    }
}
