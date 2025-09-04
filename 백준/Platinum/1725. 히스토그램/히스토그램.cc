#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    if (!(cin >> N)) return 0;

    vector<long long> h(N + 1, 0); // 마지막에 0(센티넬)
    for (int i = 0; i < N; ++i) cin >> h[i];

    stack<int> st;
    long long ans = 0;

    for (int i = 0; i <= N; ++i) {
        while (!st.empty() && h[st.top()] > h[i]) {
            long long height = h[st.top()];
            st.pop();
            long long width = st.empty() ? i : (i - st.top() - 1);
            ans = max(ans, height * width);
        }
        st.push(i);
    }

    cout << ans << '\n';
    return 0;
}