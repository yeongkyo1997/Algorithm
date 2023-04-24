# //#include <bits/stdc++.h>
# //        using namespace std;
# //
# //        #define Fi first
# //        #define Se second
# //        typedef long long ll;
# //        typedef pair<int, int> pii;
# //        typedef pair<ll, ll> pll;
# //        #define all(x) (x).begin(), (x).end()
# //        #define pb push_back
# //        #define szz(x) (int)(x).size()
# //        #define rep(i, n) for(int i=0;i<(n);i++)
# //        typedef tuple<int, int, int> t3;
# //
# //        const int RAD = 6370;
# //        using FL = long double;
# //        const FL PI = acosl(-1);
# //        const FL EPS = 1e-10;
# //        const FL INF = 1e9;
# //        typedef pair<FL, FL> pdd;
# //
# //        struct point {
#                        //        point() {}
#                                          //        point(FL x, FL y, FL z) : x(x), y(y), z(z) {}
#                                                                                               //        FL x, y, z;
# //        point normalize() {
#                             //        FL l = length();
# //        return point(x / l, y / l, z / l);
# //        }
# //        FL length() { return sqrt(x * x + y * y + z * z); }
# //        };
# //
# //        point operator*(const point &A, FL m) {
#                                                 //        return point(A.x * m, A.y * m, A.z * m);
# //        }
# //
# //        point operator-(const point &A, const point &B) {
# //        return point(A.x - B.x, A.y - B.y, A.z - B.z);
# //        }
# //
# //        point operator+(const point &A, const point &B) {
# //        return point(A.x + B.x, A.y + B.y, A.z + B.z);
# //        }
# //
# //        point operator/(const point &A, const point &B) {
# //        return point(A.y * B.z - A.z * B.y, A.z * B.x - A.x * B.z, A.x * B.y - A.y * B.x);
# //        }
# //
# //        FL operator*(const point &A, const point &B) {
# //        return A.x * B.x + A.y * B.y + A.z * B.z;
# //        }
# //        FL getAngle(point &A, point &B) {
# //        FL v = (A * B) / (A.length() * B.length());
# //        if(v < -1) v = -1;
# //        if(v > 1) v = 1;
# //        return acos(v);
# //        }
# //
# //        int N, D;
# //        point A[30], HA[30];
# //        vector <point> PL;
# //        FL dis[710][710], dx[25][25];
# //
# //        FL getDis(point P, point Q) {
# //        point vz;
# //        if((P / Q).length() <= EPS) {
# //        point tv = point(11, 12, 13);
# //        vz = (P / tv).normalize();
# //        }
# //        else vz = (P / Q).normalize();
# //        auto f = [&](point R) {
#                                 //        FL ang = getAngle(P, R);
# //        point wz = (P / R);
# //        if(wz * vz < 0) ang = -ang;
# //        return fmod(ang + 4 * PI, 2 * PI);
# //        };
# //        vector <FL> vx;
# //        vector <pdd> ux;
# //        for(int i=1;i<=N;i++) {
#     //        point vh = HA[i];
# //        point vu = vh - vz * (vh * vz);
# //        FL lu = vu.length();
# //        FL lh = vh.length();
# //        if(lu * RAD <= lh * lh) continue;
# //        point vr = vu.normalize() * (lh * lh / lu);
# //        FL c = f(vr);
# //        FL m = acos(vr.length() / RAD);
# //        FL lv = c - m;
# //        if(lv < 0) lv += 2 * PI;
# //        FL rv = c + m;
# //        if(rv >= 2 * PI) rv -= 2 * PI;
# //        ux.pb({lv, rv});
# //        vx.pb(lv), vx.pb(rv);
# //        }
# //        FL aq = getAngle(P, Q);
# //        vx.pb(0); vx.pb(aq); vx.pb(2 * PI);
# //        sort(all(vx)); vx.resize(unique(all(vx)) - vx.begin());
# //        auto get_i = [&](FL x) { return (int)(lower_bound(all(vx), x) - vx.begin()); };
# //        int m = szz(vx);
# //        vector <int> T(m, 0);
# //        for(pdd e : ux) {
#     //        FL lv = e.Fi, rv = e.Se;
# //        int li = get_i(lv);
# //        int ri = get_i(rv);
# //        T[li]++, T[ri]--;
# //        if(li > ri) T[0]++;
# //        }
# //        for(int i=1;i<m;i++) T[i] += T[i-1];
# //        int qi = get_i(aq);
# //        int mk = 0;
# //        for(int i=0;i+1<m;i++) {
# //        if(T[i] == 0 && vx[i + 1] - vx[i] > EPS) {
# //        mk |= (i < qi ? 1 : 2);
# //        }
# //        }
# //        if(!(mk & 1)) return aq * RAD;
# //        else if(!(mk & 2)) return (2 * PI - aq) * RAD;
# //        else return INF;
# //        }
# //
# //        int main() {
# //        int t; scanf("%d", &t);
# //        for(int tc=1;tc<=t;tc++) {
#                                    //        scanf("%d%d", &N, &D);
# //        printf("#%d ", tc);
# //        for(int i=1;i<=N;i++) {
# //        int a, b;
# //        scanf("%d%d", &a, &b);
# //        FL lng = (FL)a / 180 * PI;
# //        FL lat = (FL)b / 180 * PI;
# //        FL x = RAD * cos(lat) * cos(lng);
# //        FL y = RAD * cos(lat) * sin(lng);
# //        FL z = RAD * sin(lat);
# //        A[i] = point(x, y, z);
# //        HA[i] = A[i] * cos((FL)D / RAD);
# //        PL.pb(A[i]);
# //        }
# //        for(int i=1;i<=N;i++) {
# //        for(int j=1;j<i;j++) {
# //        FL ang = getAngle(A[i], A[j]);
# //        if(ang * RAD > 2 * D) continue;
# //        point vz = (HA[i] / HA[j]).normalize();
# //        point vh = (vz / HA[i]).normalize();
# //        if(vh * HA[j] < 0) vh = vh * (-1);
# //        FL lh = HA[i].length() * tan(ang / 2);
# //        point vm = HA[i] + vh * lh;
# //        FL lm = vm.length();
# //        if(lm > RAD) continue;
# //        point va = vz * sqrt(RAD * RAD - lm * lm);
# //        PL.pb(vm + va);
# //        PL.pb(vm - va);
# //        }
# //        }
# //        int M = szz(PL);
# //        rep(i, M) rep(j, M) dis[i][j] = (i == j ? 0 : INF);
# //        rep(i, M) rep(j, i) {
#                               //        dis[j][i] = dis[i][j] = getDis(PL[i], PL[j]);
# //        }
# //
# //        rep(st, N) {
#                      //        FL dl[710];
# //        int chk[710];
# //        rep(i, M) {
# //        chk[i] = 0;
# //        dl[i] = (i == st ? 0 : INF);
# //        }
# //        rep(i, M - 1) {
# //        int fi = -1;
# //        rep(j, M) if(!chk[j] && (fi == -1 || dl[fi] > dl[j])) fi = j;
# //        rep(j, M) dl[j] = min(dl[j], dl[fi] + dis[fi][j]);
# //        chk[fi] = 1;
# //        }
# //        rep(en, N) dx[st][en] = dl[en];
# //        }
# //
# //        int q; scanf("%d", &q);
# //        rep(qq, q) {
#                      //        int s, t, c;
# //        scanf("%d%d%d", &s, &t, &c);
# //        --s; --t;
# //        FL ans[25][25];
# //        rep(i, N) rep(j, N) ans[i][j] = (dx[i][j] <= c ? dx[i][j] : INF);
# //        rep(k, N) rep(i, N) rep(j, N) ans[i][j] = min(ans[i][j], ans[i][k] + ans[k][j]);
# //        if(ans[s][t] >= INF) puts("impossible");
# //        else printf("%.3Lf\n", ans[s][t]);
# //        }
# //        PL.clear();
# //        }
# //
# //        return 0;
#
# //cpp to java
#
# import java.io.BufferedReader;
# import java.io.BufferedWriter;
# import java.io.InputStreamReader;
# import java.io.OutputStreamWriter;
# import java.util.StringTokenizer;
#
# public class Main_4212_최단_비행_경로 {
# static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
# static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
# static StringTokenizer st;
#
# static int RAD = 6378;
# static final double EPS = 1e-9;
# static final double PI = Math.acos(-1.0);
# static final double INF = 1e9;
# static final int MAXN = 710;
#
#
# static int N, D;
# static point[] A = new point[MAXN];
# static point[] HA = new point[MAXN];
# static point[] PL = new point[MAXN * MAXN];
# static double[][] dis = new double[MAXN * MAXN][MAXN * MAXN];
# static double[][] dx = new double[MAXN][MAXN];
#
# static class point {
# double x, y, z;
#
# point(double x, double y, double z) {
# this.x = x;
# this.y = y;
# this.z = z;
# }
#
# point() {
# }
#
# point operator(point p) {
# return new point(x + p.x, y + p.y, z + p.z);
# }
#
# point operator(double d) {
# return new point(x * d, y * d, z * d);
# }
#
# point operator/(point p) {
# return new point(y * p.z - z * p.y, z * p.x - x * p.z, x * p.y - y * p.x);
# }
#
# point operator*(point p) {
# return new point(x * p.x, y * p.y, z * p.z);
# }
#
# double operator(point p) {
# return x * p.x + y * p.y + z * p.z;
# }
#
# double length() {
# return Math.sqrt(x * x + y * y + z * z);
# }
#
# point normalize() {
# return this.operator(1 / length());
# }
# }
#
# static double getAngle(point a, point b) {
# return Math.acos(a.operator(b));
# }
#
# static double getDis(point a, point b) {
# return getAngle(a, b) * RAD;
# }
#
# static int szz(point[] a) {
# return a.length;
# }
#
# static int szz(double[] a) {
# return a.length;
# }
#
# static double min(double a, double b) {
# return a < b ? a : b;
# }
#
#
import math

# cpp to py3

RAd = 6378
EPS = 1e-9
PI = math.acos(-1.0)
INF = 1e9
MAXN = 710


