package 미제출;

import java.util.*;
import java.io.*;

public class Main_19277_ADD_DIV_MAX {
    static long floor(long n, long d) {
        if (n > 0) {
            return n / d;
        }
        return (n - d + 1) / d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[] A = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        SegTree ST = new SegTree(N);
        ST.init(A);

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int qt = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken()) + 1;
            int R = Integer.parseInt(st.nextToken()) + 1;
            long X = Long.parseLong(st.nextToken());

            switch (qt) {
                case 0:
                    ST.update_sum(L, R, X);
                    break;
                case 1:
                    ST.update_div(L, R, X);
                    break;
                case 2:
                    bw.write(ST.query_max(L, R) + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        long mx, mi, lsq, su, lz;
        int mxct;
        boolean lsqt, lsqv;

        public Node() {
        }

        public Node(long _mx, long _mi, int _mxct, long _su, boolean _lsqv, long _lsq, boolean _lsqt, long _lz) {
            mx = _mx;
            mi = _mi;
            mxct = _mxct;
            su = _su;
            lsqv = _lsqv;
            lsq = _lsq;
            lsqt = _lsqt;
            lz = _lz;
        }

        public Node(long l, long l1, int i, long l2) {
            mx = l;
            mi = l1;
            mxct = i;
            su = l2;
        }
    }

    static class SegTree {
        int N;
        Node[] vl;

        public SegTree(int _N) {
            N = _N;
            vl = new Node[(N << 2) + 1];
            Arrays.fill(vl, new Node());
        }

        Node init(int s, int e, int n, long[] A) {
            if (s == e) {
                return vl[n] = new Node(A[s], A[s], 1, A[s]);
            }

            int m = (s + e) >> 1, k = n << 1;
            return vl[n] = addNodes(init(s, m, k, A), init(m + 1, e, k + 1, A));
        }

        void init(long[] A) {
            init(1, N, 1, A);
        }

        Node addNodes(Node l, Node r) {
            if (l.mx == r.mx) {
                return new Node(l.mx, Math.min(l.mi, r.mi), l.mxct + r.mxct, l.su + r.su);
            } else if (l.mx > r.mx) {
                return new Node(l.mx, Math.min(l.mi, r.mi), l.mxct, l.su + r.su);
            } else {
                return new Node(r.mx, Math.min(l.mi, r.mi), r.mxct, l.su + r.su);
            }
        }

        void propagate(int s, int e, int n) {
            long len = e - s + 1;

            if (s != e) {
                int k = n << 1;

                for (int i : new int[]{k, k + 1}) {
                    if (vl[n].lsqv) {
                        if (vl[n].lsqt) {
                            vl[i].lsq = vl[n].lsq;
                            vl[i].lsqt = true;
                        } else {
                            long tmx, tmi;

                            if (vl[i].lsqt) {
                                tmx = tmi = vl[i].lsq + vl[i].lz;
                            } else if (vl[i].lsq != 0) {
                                tmx = vl[i].lsq + vl[i].lz;
                                tmi = vl[i].lsq + vl[i].lz - 1;
                            } else {
                                tmx = vl[i].mx + vl[i].lz;
                                tmi = vl[i].mi + vl[i].lz;
                            }

                            if (tmx == tmi) {
                                if (tmx == vl[n].mx) {
                                    vl[i].lsq = vl[n].lsq;
                                } else {
                                    vl[i].lsq = vl[n].lsq - 1;
                                }

                                vl[i].lsqt = true;
                            } else {
                                vl[i].lsq = vl[n].lsq;
                                vl[i].lsqt = false;
                            }
                        }

                        vl[i].lsqv = true;
                        vl[i].lz = 0;
                    }

                    if (vl[n].lz != 0) {
                        vl[i].lz += vl[n].lz;
                    }
                }
            }

            if (vl[n].lsqv) {
                if (vl[n].lsqt) {
                    vl[n].mx = vl[n].mi = vl[n].lsq;
                    vl[n].su = vl[n].lsq * len;
                    vl[n].mxct = (int) len;
                } else {
                    vl[n].mx = vl[n].lsq;
                    vl[n].mi = vl[n].lsq - 1;
                    vl[n].su = (vl[n].lsq - 1) * len + vl[n].mxct;
                }
            }

            if (vl[n].lz != 0) {
                vl[n].mx += vl[n].lz;
                vl[n].mi += vl[n].lz;
                vl[n].su += vl[n].lz * len;
            }

            vl[n].lsq = 0;
            vl[n].lsqv = false;
            vl[n].lsqt = false;
            vl[n].lz = 0;
        }

        void update_sum(int s, int e, int n, int l, int r, long d) {
            propagate(s, e, n);

            if (r < s || e < l) {
                return;
            }
            if (l <= s && e <= r) {
                vl[n].lz = d;
                propagate(s, e, n);
                return;
            }

            int m = (s + e) >> 1, k = n << 1;
            update_sum(s, m, k, l, r, d);
            update_sum(m + 1, e, k + 1, l, r, d);
            vl[n] = addNodes(vl[k], vl[k + 1]);
        }

        void update_sum(int l, int r, long d) {
            update_sum(1, N, 1, l, r, d);
        }

        void update_div(int s, int e, int n, int l, int r, long d) {
            propagate(s, e, n);

            if (r < s || e < l) {
                return;
            }
            if (l <= s && e <= r) {
                long mxs = floor(vl[n].mx, d);
                long mis = floor(vl[n].mi, d);

                if (mxs == mis) {
                    vl[n].lsq = mxs;
                    vl[n].lsqv = true;
                    vl[n].lsqt = true;
                    propagate(s, e, n);
                    return;
                }

                if (vl[n].mx - vl[n].mi == 1) {
                    vl[n].lsq = mxs;
                    vl[n].lsqv = true;
                    vl[n].lsqt = false;
                    propagate(s, e, n);
                    return;
                }
            }

            int m = (s + e) >> 1, k = n << 1;
            update_div(s, m, k, l, r, d);
            update_div(m + 1, e, k + 1, l, r, d);
            vl[n] = addNodes(vl[k], vl[k + 1]);
        }

        void update_div(int l, int r, long d) {
            update_div(1, N, 1, l, r, d);
        }

        long query_sum(int s, int e, int n, int l, int r) {
            propagate(s, e, n);

            if (r < s || e < l) {
                return 0L;
            }
            if (l <= s && e <= r) {
                return vl[n].su;
            }

            int m = (s + e) >> 1, k = n << 1;
            return query_sum(s, m, k, l, r) + query_sum(m + 1, e, k + 1, l, r);
        }

        long query_sum(int l, int r) {
            return query_sum(1, N, 1, l, r);
        }

        long query_min(int s, int e, int n, int l, int r) {
            propagate(s, e, n);

            if (r < s || e < l) {
                return Long.MAX_VALUE;
            }
            if (l <= s && e <= r) {
                return vl[n].mi;
            }

            int m = (s + e) >> 1, k = n << 1;
            return Math.min(query_min(s, m, k, l, r), query_min(m + 1, e, k + 1, l, r));
        }

        long query_min(int l, int r) {
            return query_min(1, N, 1, l, r);
        }

        long query_max(int s, int e, int n, int l, int r) {
            propagate(s, e, n);

            if (r < s || e < l) {
                return Long.MIN_VALUE;
            }
            if (l <= s && e <= r) {
                return vl[n].mx;
            }

            int m = (s + e) >> 1, k = n << 1;
            return Math.max(query_max(s, m, k, l, r), query_max(m + 1, e, k + 1, l, r));
        }

        long query_max(int l, int r) {
            return query_max(1, N, 1, l, r);
        }
    }
}
