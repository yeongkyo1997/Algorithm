#include <bits/stdc++.h>
using namespace std;

struct Query {
    int l, r, idx;
    int block;
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    if (!(cin >> N >> K)) return 0;
    vector<int> A(N + 1);
    for (int i = 1; i <= N; ++i) cin >> A[i];

    int M; cin >> M;
    vector<Query> qs(M);
    for (int i = 0; i < M; ++i) {
        int l, r; cin >> l >> r;
        qs[i] = {l, r, i, 0};
    }

    // Mo's block size for indices
    int BLK = max(1, (int)sqrt(N));
    for (auto &q : qs) q.block = q.l / BLK;
    sort(qs.begin(), qs.end(), [&](const Query& a, const Query& b){
        if (a.block != b.block) return a.block < b.block;
        if (a.block & 1) return a.r > b.r;
        return a.r < b.r;
    });

    // Precompute occurrence lists for each value and rank of each index in its value list
    vector<vector<int>> occ(K + 1);
    occ.shrink_to_fit(); // avoid extra capacity
    for (int i = 1; i <= N; ++i) occ[A[i]].push_back(i);

    vector<int> rankInOcc(N + 1);
    for (int v = 1; v <= K; ++v) {
        auto &ov = occ[v];
        for (int i = 0; i < (int)ov.size(); ++i) rankInOcc[ov[i]] = i;
    }

    // For each value v: count in window, and pointers (indices in occ[v]) to first/last inside window
    vector<int> cnt(K + 1, 0), lptr(K + 1, 0), rptr(K + 1, -1);

    // Frequency of distances and sqrt-buckets for quick max
    // dist in [1 .. N-1]
    int DMax = max(1, N);               // allocate size N+1 to be safe
    vector<int> freq(DMax + 1, 0);
    int DBLK = max(1, (int)sqrt(N));    // bucket size for distances
    int BNUM = (DMax + DBLK) / DBLK + 2;
    vector<int> bsum(BNUM, 0);

    auto incDist = [&](int d) {
        if (d <= 0) return;
        ++freq[d];
        ++bsum[d / DBLK];
    };
    auto decDist = [&](int d) {
        if (d <= 0) return;
        --freq[d];
        --bsum[d / DBLK];
    };
    auto distOf = [&](int v)->int {
        if (cnt[v] < 2) return 0;
        return occ[v][rptr[v]] - occ[v][lptr[v]];
    };
    auto addLeft = [&](int idx) {
        int v = A[idx];
        if (cnt[v] >= 2) decDist(distOf(v));
        if (cnt[v] == 0) {
            lptr[v] = rptr[v] = rankInOcc[idx];
        } else {
            // new index is just before current lptr
            --lptr[v];
        }
        ++cnt[v];
        if (cnt[v] >= 2) incDist(distOf(v));
    };
    auto addRight = [&](int idx) {
        int v = A[idx];
        if (cnt[v] >= 2) decDist(distOf(v));
        if (cnt[v] == 0) {
            lptr[v] = rptr[v] = rankInOcc[idx];
        } else {
            // new index is just after current rptr
            ++rptr[v];
        }
        ++cnt[v];
        if (cnt[v] >= 2) incDist(distOf(v));
    };
    auto removeLeft = [&](int idx) {
        int v = A[idx];
        if (cnt[v] >= 2) decDist(distOf(v));
        if (cnt[v] == 1) {
            cnt[v] = 0; // now empty
        } else {
            ++lptr[v];
            --cnt[v];
            if (cnt[v] >= 2) incDist(distOf(v));
        }
    };
    auto removeRight = [&](int idx) {
        int v = A[idx];
        if (cnt[v] >= 2) decDist(distOf(v));
        if (cnt[v] == 1) {
            cnt[v] = 0; // now empty
        } else {
            --rptr[v];
            --cnt[v];
            if (cnt[v] >= 2) incDist(distOf(v));
        }
    };
    auto getMaxDist = [&]()->int {
        for (int b = (int)bsum.size() - 1; b >= 0; --b) {
            if (bsum[b] == 0) continue;
            int hi = min(DMax, (b + 1) * DBLK - 1);
            int lo = b * DBLK;
            for (int d = hi; d >= lo; --d) {
                if (d < (int)freq.size() && freq[d] > 0) return d;
            }
        }
        return 0; // no duplicates in window
    };

    vector<int> ans(M, 0);
    int curL = 1, curR = 0; // empty window

    for (const auto &q : qs) {
        while (curL > q.l) addLeft(--curL);
        while (curR < q.r) addRight(++curR);
        while (curL < q.l) removeLeft(curL++);
        while (curR > q.r) removeRight(curR--);
        ans[q.idx] = getMaxDist();
    }

    for (int i = 0; i < M; ++i) {
        cout << ans[i] << '\n';
    }
    return 0;
}