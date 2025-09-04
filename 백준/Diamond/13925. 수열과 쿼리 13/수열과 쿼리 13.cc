#include <bits/stdc++.h>
using namespace std;

using int64 = long long;
const int64 MOD = 1'000'000'007LL;

struct Node {
    int64 sum = 0;     // 구간 합
    int64 add = 0;     // 지연 add(b)
    int64 mul = 1;     // 지연 mul(a)
    int64 setVal = 0;  // 지연 set 값
    bool hasSet = false; // 지연 set 존재 여부
};

int N, M;
vector<int64> A;
vector<Node> seg;

inline int64 norm(int64 x) { x %= MOD; if (x < 0) x += MOD; return x; }

void apply_set(int idx, int64 v, int len) {
    v = norm(v);
    seg[idx].sum = (v * len) % MOD;
    seg[idx].setVal = v;
    seg[idx].hasSet = true;
    seg[idx].mul = 1;
    seg[idx].add = 0;
}

void apply_mul(int idx, int64 v, int len) {
    v = norm(v);
    seg[idx].sum = (seg[idx].sum * v) % MOD;
    if (seg[idx].hasSet) {
        seg[idx].setVal = (seg[idx].setVal * v) % MOD;
    } else {
        seg[idx].mul = (seg[idx].mul * v) % MOD;
        seg[idx].add = (seg[idx].add * v) % MOD;
    }
}

void apply_add(int idx, int64 v, int len) {
    v = norm(v);
    seg[idx].sum = (seg[idx].sum + v * len) % MOD;
    if (seg[idx].hasSet) {
        seg[idx].setVal = (seg[idx].setVal + v) % MOD;
    } else {
        seg[idx].add = (seg[idx].add + v) % MOD;
    }
}

void push(int idx, int l, int r) {
    if (l == r) return;
    int mid = (l + r) >> 1;
    int L = idx << 1, R = L | 1;

    if (seg[idx].hasSet) {
        apply_set(L, seg[idx].setVal, mid - l + 1);
        apply_set(R, seg[idx].setVal, r - mid);
        seg[idx].hasSet = false;
    }
    if (seg[idx].mul != 1) {
        int64 m = seg[idx].mul;
        apply_mul(L, m, mid - l + 1);
        apply_mul(R, m, r - mid);
        seg[idx].mul = 1;
    }
    if (seg[idx].add != 0) {
        int64 a = seg[idx].add;
        apply_add(L, a, mid - l + 1);
        apply_add(R, a, r - mid);
        seg[idx].add = 0;
    }
}

void pull(int idx) {
    seg[idx].sum = (seg[idx<<1].sum + seg[idx<<1|1].sum) % MOD;
}

void build(int idx, int l, int r) {
    if (l == r) {
        seg[idx].sum = norm(A[l]);
        seg[idx].mul = 1; seg[idx].add = 0; seg[idx].hasSet = false;
        return;
    }
    int mid = (l + r) >> 1;
    build(idx<<1, l, mid);
    build(idx<<1|1, mid+1, r);
    pull(idx);
}

void range_add(int idx, int l, int r, int ql, int qr, int64 v) {
    if (qr < l || r < ql) return;
    if (ql <= l && r <= qr) {
        apply_add(idx, v, r - l + 1);
        return;
    }
    push(idx, l, r);
    int mid = (l + r) >> 1;
    range_add(idx<<1, l, mid, ql, qr, v);
    range_add(idx<<1|1, mid+1, r, ql, qr, v);
    pull(idx);
}

void range_mul(int idx, int l, int r, int ql, int qr, int64 v) {
    if (qr < l || r < ql) return;
    if (ql <= l && r <= qr) {
        apply_mul(idx, v, r - l + 1);
        return;
    }
    push(idx, l, r);
    int mid = (l + r) >> 1;
    range_mul(idx<<1, l, mid, ql, qr, v);
    range_mul(idx<<1|1, mid+1, r, ql, qr, v);
    pull(idx);
}

void range_set(int idx, int l, int r, int ql, int qr, int64 v) {
    if (qr < l || r < ql) return;
    if (ql <= l && r <= qr) {
        apply_set(idx, v, r - l + 1);
        return;
    }
    push(idx, l, r);
    int mid = (l + r) >> 1;
    range_set(idx<<1, l, mid, ql, qr, v);
    range_set(idx<<1|1, mid+1, r, ql, qr, v);
    pull(idx);
}

int64 range_sum(int idx, int l, int r, int ql, int qr) {
    if (qr < l || r < ql) return 0;
    if (ql <= l && r <= qr) return seg[idx].sum;
    push(idx, l, r);
    int mid = (l + r) >> 1;
    return (range_sum(idx<<1, l, mid, ql, qr) +
            range_sum(idx<<1|1, mid+1, r, ql, qr)) % MOD;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    A.assign(N + 1, 0);
    for (int i = 1; i <= N; ++i) cin >> A[i];

    seg.assign(4 * N + 5, Node());
    build(1, 1, N);

    cin >> M;
    while (M--) {
        int type, x, y;
        long long v;
        cin >> type >> x >> y;
        if (type == 4) {
            cout << range_sum(1, 1, N, x, y) << '\n';
        } else {
            cin >> v;
            if (type == 1) {
                range_add(1, 1, N, x, y, v);
            } else if (type == 2) {
                range_mul(1, 1, N, x, y, v);
            } else if (type == 3) {
                range_set(1, 1, N, x, y, v);
            }
        }
    }
    return 0;
}