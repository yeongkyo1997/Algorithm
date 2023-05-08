import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_3835_Alphabet_Soup {
    static final long MOD = 1000000007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int k, n;
    static int[] d;
    static List<Integer> g1, g2;
    static KMP kmp;

    static long pw (long a, long b) {
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res *= a;
                res %= MOD;
            }
            a *= a;
            a %= MOD;
            b >>= 1;
        }
        return res;
    }


    static long divmod (long a, long b, long mod) {
        long res = 1;
        long ex = mod - 2;
        while (ex > 0) {
            if (ex % 2 != 0) {
                res = (res * b) % mod;
            }
            b = (b * b) % mod;
            try {
                ex /= 2;
            } catch (Exception e) {
                return -1;
            }
        }
        res = (res * a) % mod;
        return res;
    }

    static void solve () throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (n == -1) break;

            d = new int[n];
            for (int i = 0; i < n; ++i) {
                d[i] = Integer.parseInt(br.readLine());
            }
            br.readLine();
            Arrays.sort(d);
            g1 = new ArrayList<>();
            g2 = new ArrayList<>();
            for (int i = 0; i < n - 1; ++i) {
                g1.add(d[i + 1] - d[i]);
                g2.add(g1.get(i));
                g2.add(g1.get(i));
            }
            g1.add(d[0] + 360000 - d[n - 1]);
            g2.add(g1.get(n - 1));

            List<Integer> knum = new ArrayList<>();
            kmp.get(g2, g1, knum);
            int gap;
            try {
                gap = n / knum.size();
            } catch (Exception e) {
                System.out.println(-1);
                continue;
            }

            long res = 0;
            for (int i = 0; i < n; i += gap) {
                res += pw(k, gcd(n, i));
                res %= MOD;
            }
            res = divmod(res, knum.size(), MOD);

            bw.write(res + "\n");
        }
    }

    static int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main (String[] args) throws Exception {
        kmp = new KMP();
        kmp.fail = new ArrayList<>();
        solve();
        bw.flush();
        bw.close();
        br.close();
    }

    static class KMP {
        List<Integer> fail;

        void init_fail (List<Integer> w) {
            int wn = w.size();
            fail.clear();
            for (int i = 0; i < wn; ++i) {
                fail.add(0);
            }

            int j = 0;
            for (int i = 1; i < wn; ++i) {
                while (j > 0 && !Objects.equals(w.get(i), w.get(j))) {
                    j = fail.get(j - 1);
                }
                if (Objects.equals(w.get(i), w.get(j))) {
                    fail.set(i, j + 1);
                    j++;
                }
            }
        }

        void get (List<Integer> s, List<Integer> w, List<Integer> res) {
            init_fail(w);
            res.clear();

            int sn = s.size();
            int wn = w.size();

            int j = 0;
            for (int i = 0; i < sn; ++i) {
                while (j > 0 && !Objects.equals(s.get(i), w.get(j))) {
                    j = fail.get(j - 1);
                }
                if (Objects.equals(s.get(i), w.get(j))) {
                    if (j == wn - 1) {
                        res.add(i - wn + 1);
                        j = fail.get(j);
                    } else {
                        j++;
                    }
                }
            }
        }
    }
}