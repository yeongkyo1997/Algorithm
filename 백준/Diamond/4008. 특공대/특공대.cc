#include <bits/stdc++.h>
using namespace std;

using int64 = long long;

struct Line {
    int64 m; // slope
    int64 b; // intercept
    // evaluate at x
    inline int64 eval(int64 x) const {
        return m * x + b;
    }
};

// l2가 l1과 l3 사이에서 쓸모없는지 판단 (기울기 증가 가정: m1 < m2 < m3)
// x12 >= x23 이면 l2는 불필요.
// (b1 - b2)/(m2 - m1) >= (b2 - b3)/(m3 - m2)
// (b1 - b2)*(m3 - m2) >= (b2 - b3)*(m2 - m1)
static inline bool bad(const Line& l1, const Line& l2, const Line& l3) {
    __int128 left  = (__int128)(l1.b - l2.b) * (l3.m - l2.m);
    __int128 right = (__int128)(l2.b - l3.b) * (l2.m - l1.m);
    return left >= right;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    if (!(cin >> n)) return 0;
    int64 a, b, c;
    cin >> a >> b >> c;

    deque<Line> hull;
    auto add_line = [&](int64 m, int64 k) {
        Line L{m, k};
        while (hull.size() >= 2 && bad(hull[hull.size()-2], hull[hull.size()-1], L))
            hull.pop_back();
        hull.push_back(L);
    };
    auto query = [&](int64 x) -> int64 {
        while (hull.size() >= 2 && hull[0].eval(x) <= hull[1].eval(x))
            hull.pop_front();
        return hull.front().eval(x);
    };

    // 초기 상태: j=0 라인 추가 (S[0]=0, dp[0]=0)
    // m0 = -2*a*S[0] = 0, b0 = dp[0] + a*S[0]^2 - b*S[0] = 0
    add_line(0, 0);

    int64 S = 0;      // prefix sum
    int64 dp = 0;     // dp[i]
    for (int i = 1; i <= n; ++i) {
        int64 x;
        cin >> x;
        S += x;

        // best = max_j (m_j * S + b_j)
        int64 best = query(S);

        // dp[i] = a*S^2 + b*S + c + best
        int64 dp_i = a * S * S + b * S + c + best;

        // 새 라인 추가: m_i = -2*a*S, b_i = dp[i] + a*S^2 - b*S
        int64 m_i = -2 * a * S;
        int64 k_i = dp_i + a * S * S - b * S;
        add_line(m_i, k_i);

        dp = dp_i;
    }

    cout << dp << '\n';
    return 0;
}