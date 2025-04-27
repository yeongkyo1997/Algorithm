#include <iostream>
#include <vector>
#include <algorithm>
#include <tuple>        // 추가된 부분
using namespace std;
using ll = long long;

// 세그먼트 트리 각 노드 정보
struct Node {
    ll sum;   // 구간 전체 합
    ll pref;  // 구간 접두사 최대 합
    ll suff;  // 구간 접미사 최대 합
    ll best;  // 구간 부분 배열(아무 위치든) 최대 합
};

// 두 자식 노드를 합쳐 부모 노드 정보를 생성
Node combine(const Node &a, const Node &b) {
    Node c;
    c.sum  = a.sum + b.sum;
    c.pref = max(a.pref, a.sum + b.pref);
    c.suff = max(b.suff, b.sum + a.suff);
    c.best = max( max(a.best, b.best), a.suff + b.pref );
    return c;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<ll> xs, ys;
    xs.reserve(N);
    ys.reserve(N);
    vector<tuple<ll,ll,ll>> pts(N);  // tuple 사용

    // 입력 읽기 및 좌표 리스트에 저장
    for (int i = 0; i < N; i++) {
        ll x, y, w;
        cin >> x >> y >> w;
        pts[i] = make_tuple(x, y, w);
        xs.push_back(x);
        ys.push_back(y);
    }

    // x, y 좌표 압축
    sort(xs.begin(), xs.end());
    xs.erase(unique(xs.begin(), xs.end()), xs.end());
    sort(ys.begin(), ys.end());
    ys.erase(unique(ys.begin(), ys.end()), ys.end());
    int X = xs.size(), Y = ys.size();

    // 같은 y좌표를 가진 점들을 모아둠
    vector<vector<pair<int,ll>>> byY(Y);
    for (auto &t : pts) {
        ll x, y, w;
        tie(x, y, w) = t;  // tie 사용 가능
        int xi = lower_bound(xs.begin(), xs.end(), x) - xs.begin();
        int yi = lower_bound(ys.begin(), ys.end(), y) - ys.begin();
        byY[yi].push_back({xi, w});
    }

    // 세그먼트 트리 크기 결정
    int size = 1;
    while (size < X) size <<= 1;
    vector<Node> tree(2 * size);

    ll answer = 0;
    // y범위 [i..j] 로 스위핑
    for (int i = 0; i < Y; i++) {
        // 트리 초기화
        for (int k = 1; k < 2*size; k++)
            tree[k] = {0,0,0,0};

        for (int j = i; j < Y; j++) {
            // y = ys[j] 에 해당하는 모든 점 반영
            for (auto &p : byY[j]) {
                int pos = p.first;
                ll w  = p.second;
                int node = pos + size;
                tree[node].sum  += w;
                ll s = tree[node].sum;
                tree[node].pref = s;
                tree[node].suff = s;
                tree[node].best = s;
                node >>= 1;
                while (node > 0) {
                    tree[node] = combine(tree[2*node], tree[2*node+1]);
                    node >>= 1;
                }
            }
            // 현재 y-구간[i..j]에서 최대 이익 갱신
            answer = max(answer, tree[1].best);
        }
    }

    cout << answer << "\n";
    return 0;
}
