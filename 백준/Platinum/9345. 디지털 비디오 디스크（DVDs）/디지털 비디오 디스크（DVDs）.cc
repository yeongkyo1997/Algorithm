#include <cstdio>
#include <algorithm>
#define MAX_N 100000
#define INF 987654321
using namespace std;
int t, n, k, maxseg[4 * MAX_N], minseg[4 * MAX_N], q, a, b, dvd[MAX_N];
int maxupdate(int pos, int val, int node, int x, int y) {
    if (y < pos || pos < x)
        return maxseg[node];
    if (x == y)
        return maxseg[node] = val;
    int mid = (x + y) >> 1;
    return maxseg[node] = max(maxupdate(pos, val, node * 2, x, mid), maxupdate(pos, val, node * 2 + 1, mid + 1, y));
}
int maxquery(int lo, int hi, int node, int x, int y) {
    if (y < lo || hi < x)
        return -INF;
    if (lo <= x&&y <= hi)
        return maxseg[node];
    int mid = (x + y) >> 1;
    return max(maxquery(lo, hi, node * 2, x, mid), maxquery(lo, hi, node * 2 + 1, mid + 1, y));
}
int minupdate(int pos, int val, int node, int x, int y) {
    if (y < pos || pos < x)
        return minseg[node];
    if (x == y)
        return minseg[node] = val;
    int mid = (x + y) >> 1;
    return minseg[node] = min(minupdate(pos, val, node * 2, x, mid), minupdate(pos, val, node * 2 + 1, mid + 1, y));
}
int minquery(int lo, int hi, int node, int x, int y) {
    if (y < lo || hi < x)
        return INF;
    if (lo <= x&&y <= hi)
        return minseg[node];
    int mid = (x + y) >> 1;
    return min(minquery(lo, hi, node * 2, x, mid), minquery(lo, hi, node * 2 + 1, mid + 1, y));
}
int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%d%d", &n, &k);
        for (int i = 0; i < n; i++) {
            maxupdate(i, i, 1, 0, n - 1);
            minupdate(i, i, 1, 0, n - 1);
            dvd[i] = i;
        }
        for (int i = 0; i < k; i++) {
            scanf("%d%d%d", &q, &a, &b);
            if (q) {
                printf("%s\n", make_pair(b, a) == make_pair(maxquery(a, b, 1, 0, n - 1), minquery(a, b, 1, 0, n - 1)) ? "YES" : "NO");
            }
            else {
                swap(dvd[a], dvd[b]);
                maxupdate(a, dvd[a], 1, 0, n - 1);
                maxupdate(b, dvd[b], 1, 0, n - 1);
                minupdate(a, dvd[a], 1, 0, n - 1);
                minupdate(b, dvd[b], 1, 0, n - 1);
            }
        }
    }
    return 0;
}