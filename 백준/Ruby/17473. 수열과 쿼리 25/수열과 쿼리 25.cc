#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAXN = 200000;
const int FULL_MASK = (1 << 20) - 1;

// 트리의 각 노드 정보
struct Node {
    int mx;        // 구간 내 최대값
    int mn_and;    // 구간 내 모든 값의 비트 AND
    int mx_or;     // 구간 내 모든 값의 비트 OR
    int lz_and;    // 지연 AND 마스크
    int lz_or;     // 지연 OR 마스크
} seg[4*MAXN+5];

int N, M;
int A[MAXN+1];

// 노드 초기화
void init_node(int idx, int l, int r) {
    seg[idx].lz_and = FULL_MASK;  // AND 마스크 초기값은 전부 1
    seg[idx].lz_or  = 0;          // OR 마스크 초기값은 전부 0
    if (l == r) {
        int v = A[l];
        seg[idx].mx     = v;
        seg[idx].mn_and = v;
        seg[idx].mx_or  = v;
    } else {
        int m = (l + r) >> 1;
        init_node(idx<<1, l, m);
        init_node(idx<<1|1, m+1, r);
        // 자식에서 정보 끌어오기
        seg[idx].mx     = max(seg[idx<<1].mx, seg[idx<<1|1].mx);
        seg[idx].mn_and = seg[idx<<1].mn_and & seg[idx<<1|1].mn_and;
        seg[idx].mx_or  = seg[idx<<1].mx_or  | seg[idx<<1|1].mx_or;
    }
}

// 노드에 AND 태그 적용 함수
inline void apply_and(int idx, int mask) {
    // 기존 값에 비트 AND
    seg[idx].mx     &= mask;
    seg[idx].mn_and &= mask;
    seg[idx].mx_or  &= mask;
    // 지연 태그 합성: f(x) = ( (x & lz_and) | lz_or ) & mask
    seg[idx].lz_and &= mask;
    seg[idx].lz_or  &= mask;
}

// 노드에 OR 태그 적용 함수
inline void apply_or(int idx, int mask) {
    seg[idx].mx     |= mask;
    seg[idx].mn_and |= mask;
    seg[idx].mx_or  |= mask;
    // 지연 태그 합성: f(x) = ( (x & lz_and) | lz_or ) | mask
    seg[idx].lz_or |= mask;
}

// 자식에게 지연 태그 전파
void push(int idx) {
    if (seg[idx].lz_and != FULL_MASK || seg[idx].lz_or != 0) {
        apply_and(idx<<1, seg[idx].lz_and);
        apply_or (idx<<1, seg[idx].lz_or);
        apply_and(idx<<1|1, seg[idx].lz_and);
        apply_or (idx<<1|1, seg[idx].lz_or);
        // 현재 노드 지연 태그 초기화
        seg[idx].lz_and = FULL_MASK;
        seg[idx].lz_or  = 0;
    }
}

// 자식에서 정보 갱신
inline void pull(int idx) {
    seg[idx].mx     = max(seg[idx<<1].mx, seg[idx<<1|1].mx);
    seg[idx].mn_and = seg[idx<<1].mn_and & seg[idx<<1|1].mn_and;
    seg[idx].mx_or  = seg[idx<<1].mx_or  | seg[idx<<1|1].mx_or;
}

// 구간 [L,R] 에 AND 연산
void upd_and(int idx, int l, int r, int L, int R, int mask) {
    if (r < L || R < l) return;
    if (L <= l && r <= R) {
        // 이 구간에서 0으로 클리어할 비트가 모두 균일하면(모두 0이거나 모두 1이어서)
        int bits_to_clear = seg[idx].mx_or & (~mask);
        if ((seg[idx].mn_and & (~mask)) == bits_to_clear) {
            // 안전하게 태그로 처리
            apply_and(idx, mask);
            return;
        }
    }
    if (l == r) {
        // 리프 노드면 직접 적용
        seg[idx].mx     &= mask;
        seg[idx].mn_and &= mask;
        seg[idx].mx_or  &= mask;
        return;
    }
    push(idx);
    int m = (l + r) >> 1;
    upd_and(idx<<1, l, m, L, R, mask);
    upd_and(idx<<1|1, m+1, r, L, R, mask);
    pull(idx);
}

// 구간 [L,R] 에 OR 연산
void upd_or(int idx, int l, int r, int L, int R, int mask) {
    if (r < L || R < l) return;
    if (L <= l && r <= R) {
        // 이 구간에서 1로 세팅할 비트가 모두 균일하면(모두 0이거나 모두 1)
        int bits_to_set = (~seg[idx].mn_and) & mask;
        if ((~seg[idx].mx_or & mask) == bits_to_set) {
            apply_or(idx, mask);
            return;
        }
    }
    if (l == r) {
        seg[idx].mx     |= mask;
        seg[idx].mn_and |= mask;
        seg[idx].mx_or  |= mask;
        return;
    }
    push(idx);
    int m = (l + r) >> 1;
    upd_or(idx<<1, l, m, L, R, mask);
    upd_or(idx<<1|1, m+1, r, L, R, mask);
    pull(idx);
}

// 구간 [L,R] 최대값 조회
int query_max(int idx, int l, int r, int L, int R) {
    if (r < L || R < l) return 0;
    if (L <= l && r <= R) {
        return seg[idx].mx;
    }
    push(idx);
    int m = (l + r) >> 1;
    return max(
        query_max(idx<<1, l, m, L, R),
        query_max(idx<<1|1, m+1, r, L, R)
    );
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // 입력
    cin >> N;
    for (int i = 1; i <= N; ++i) {
        cin >> A[i];
    }
    init_node(1, 1, N);

    cin >> M;
    while (M--) {
        int t, L, R, X;
        cin >> t >> L >> R;
        if (t == 1) {
            cin >> X;
            upd_and(1, 1, N, L, R, X);
        } else if (t == 2) {
            cin >> X;
            upd_or(1, 1, N, L, R, X);
        } else {
            cout << query_max(1, 1, N, L, R) << "\n";
        }
    }
    return 0;
}
