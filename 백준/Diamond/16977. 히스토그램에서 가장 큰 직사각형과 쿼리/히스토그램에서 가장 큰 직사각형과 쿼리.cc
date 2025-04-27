#include <bits/stdc++.h>
using namespace std;
using ll = long long;

// 최대 노드 수: build 약 2N, update N·logN → 충분히 감당
static const int MAXNODE = 3000000;

// 영역 [l..r]에 대해 “1이면 활성, 0이면 비활성”일 때
// 연속 1의 최대 길이를 관리하는 퍼시스턴트 세그트리 노드
struct PSTNode {
    int lch, rch;  // 좌/우 자식 인덱스
    int len;       // 이 노드가 담당하는 구간 길이
    int pref;      // 구간 접두사 연속 1 최대 길이
    int suff;      // 구간 접미사 연속 1 최대 길이
    int best;      // 구간 내 연속 1 최대 길이
} pool[MAXNODE];

int poolPtr = 0;

// [l..r] 범위에 대해 모두 0으로 초기화된 트리 생성
int build(int l, int r) {
    int id = poolPtr++;
    pool[id].len  = r - l + 1;
    pool[id].pref = pool[id].suff = pool[id].best = 0;
    if (l == r) {
        pool[id].lch = pool[id].rch = -1;
    } else {
        int m = (l + r) >> 1;
        pool[id].lch = build(l, m);
        pool[id].rch = build(m + 1, r);
    }
    return id;
}

// 이전 버전 prev_root에서 pos 위치를 1로 바꾼 새 버전 생성
int update(int prev_root, int l, int r, int pos) {
    int id = poolPtr++;
    // 이전 노드 복사 (len, lch, rch 포함)
    pool[id] = pool[prev_root];
    if (l == r) {
        // 리프: 연속 1 길이 모두 1
        pool[id].pref = pool[id].suff = pool[id].best = 1;
    } else {
        int m = (l + r) >> 1;
        if (pos <= m) {
            pool[id].lch = update(pool[prev_root].lch, l, m, pos);
        } else {
            pool[id].rch = update(pool[prev_root].rch, m + 1, r, pos);
        }
        // 자식 노드 가져오기
        PSTNode &L = pool[ pool[id].lch ];
        PSTNode &R = pool[ pool[id].rch ];
        // 구간 접두사: 왼쪽 구간 전체가 1이면 넘어가고, 아니면 왼쪽 pref
        pool[id].pref = (L.pref == L.len ? L.len + R.pref : L.pref);
        // 구간 접미사: 오른쪽 구간 전체가 1이면 넘어가고, 아니면 오른쪽 suff
        pool[id].suff = (R.suff == R.len ? R.len + L.suff : R.suff);
        // 구간 내 최댓값: 왼쪽 best, 오른쪽 best, 경계 연결
        pool[id].best = max({ L.best, R.best, L.suff + R.pref });
    }
    return id;
}

// 쿼리용 노드 (범위 길이 + pref/suff/best)
struct QNode {
    int len, pref, suff, best;
    QNode(int _len=0, int _pref=0, int _suff=0, int _best=0)
        : len(_len), pref(_pref), suff(_suff), best(_best) {}
};

// QNode 합치는 함수
QNode combineQ(const QNode &A, const QNode &B) {
    QNode C;
    C.len  = A.len + B.len;
    C.pref = (A.pref == A.len ? A.len + B.pref : A.pref);
    C.suff = (B.suff == B.len ? B.len + A.suff : B.suff);
    C.best = max({ A.best, B.best, A.suff + B.pref });
    return C;
}

// 버전 root에서 [ql..qr] 범위에 대한 QNode 반환
QNode query(int root, int l, int r, int ql, int qr) {
    if (qr < l || r < ql) return QNode(0, 0, 0, 0);
    if (ql <= l && r <= qr) {
        PSTNode &nd = pool[root];
        return QNode(nd.len, nd.pref, nd.suff, nd.best);
    }
    int m = (l + r) >> 1;
    QNode L = query(pool[root].lch, l, m, ql, qr);
    QNode R = query(pool[root].rch, m + 1, r, ql, qr);
    return combineQ(L, R);
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<ll> H(N+1);
    for (int i = 1; i <= N; i++) {
        cin >> H[i];
    }

    // 고유한 높이들 내림차순 정렬
    vector<ll> vh(H.begin()+1, H.end());
    sort(vh.begin(), vh.end());
    vh.erase(unique(vh.begin(), vh.end()), vh.end());
    sort(vh.begin(), vh.end(), greater<ll>());
    int M = vh.size();

    // 각 높이에 해당하는 인덱스들 모으기
    vector<vector<int>> pos(M);
    for (int i = 1; i <= N; i++) {
        int k = lower_bound(vh.begin(), vh.end(), H[i], greater<ll>()) - vh.begin();
        pos[k].push_back(i);
    }

    // 빈 버전 생성
    vector<int> roots(M+1);
    roots[0] = build(1, N);
    // 차례로 “높이 ≥ vh[k-1]”인 바를 1로 세팅
    for (int k = 1; k <= M; k++) {
        int curr = roots[k-1];
        for (int idx : pos[k-1]) {
            curr = update(curr, 1, N, idx);
        }
        roots[k] = curr;
    }

    int Q;
    cin >> Q;
    while (Q--) {
        int l, r, w;
        cin >> l >> r >> w;
        // 내림차순 vh를 기준으로 이분 탐색: 
        // 첫 버전 mid에서 가장 긴 연속 1 길이 ≥ w인 최소 mid 찾기
        int lo = 1, hi = M, ans = M;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            QNode res = query(roots[mid], 1, N, l, r);
            if (res.best >= w) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        // 출력: vh[ans-1]가 최대가 되는 최소 높이
        cout << vh[ans-1] << "\n";
    }
    return 0;
}
