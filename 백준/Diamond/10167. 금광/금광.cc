#include <bits/stdc++.h>
using namespace std;

using ll = long long;

struct Node {
    ll sum = 0;   // 구간 합
    ll pref = 0;  // 최대 접두사 합
    ll suff = 0;  // 최대 접미사 합
    ll best = 0;  // 최대 부분합
};

inline Node mergeNode(const Node& L, const Node& R) {
    Node res;
    res.sum  = L.sum + R.sum;
    res.pref = max(L.pref, L.sum + R.pref);
    res.suff = max(R.suff, R.sum + L.suff);
    res.best = max({L.best, R.best, L.suff + R.pref});
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    if (!(cin >> N)) return 0;

    struct P { int x, y; ll w; };
    vector<P> pts(N);
    vector<int> xs, ys;
    xs.reserve(N); ys.reserve(N);

    for (int i = 0; i < N; ++i) {
        int x, y; ll w;
        cin >> x >> y >> w;
        pts[i] = {x, y, w};
        xs.push_back(x);
        ys.push_back(y);
    }

    // x, y 좌표 압축
    sort(xs.begin(), xs.end());
    xs.erase(unique(xs.begin(), xs.end()), xs.end());
    sort(ys.begin(), ys.end());
    ys.erase(unique(ys.begin(), ys.end()), ys.end());

    int X = (int)xs.size();
    int Y = (int)ys.size();

    // 각 y-레벨마다 (압축 x인덱스, w)를 모아둔다.
    vector<vector<pair<int, ll>>> byY(Y);
    byY.reserve(Y);
    for (auto &p : pts) {
        int xi = int(lower_bound(xs.begin(), xs.end(), p.x) - xs.begin());
        int yi = int(lower_bound(ys.begin(), ys.end(), p.y) - ys.begin());
        byY[yi].push_back({xi, p.w});
    }

    // 세그먼트 트리(반복형) 준비
    int S = 1;
    while (S < X) S <<= 1;
    vector<Node> seg(2 * S); // 1-based root

    auto clearTree = [&]() {
        // 모든 노드를 0으로 초기화
        fill(seg.begin(), seg.end(), Node());
    };

    auto addPoint = [&](int pos, ll delta) {
        // pos: 0-based in [0, X-1]
        int i = pos + S;
        seg[i].sum  += delta;
        seg[i].pref = seg[i].suff = seg[i].best = seg[i].sum;
        for (i >>= 1; i >= 1; i >>= 1) {
            seg[i] = mergeNode(seg[i << 1], seg[i << 1 | 1]);
        }
    };

    ll ans = LLONG_MIN;

    // bottom y를 고정하고 top을 올려가며 누적
    for (int b = 0; b < Y; ++b) {
        clearTree();
        for (int t = b; t < Y; ++t) {
            for (auto &e : byY[t]) {
                addPoint(e.first, e.second);
            }
            ans = max(ans, seg[1].best);
        }
    }

    cout << ans << '\n';
    return 0;
}