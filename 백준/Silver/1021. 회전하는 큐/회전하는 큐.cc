#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    deque<int> q(n);
    for (int i = 0; i < n; i++) {
        q[i] = i + 1;
    }
    int ans = 0;
    for (int i = 0; i < m; i++) {
        int idx;
        cin >> idx;
        int cnt = 0;
        while (q.front() != idx) {
            if (find(q.begin(), q.begin() + q.size() / 2, idx) != q.begin() + q.size() / 2) {
                q.push_back(q.front());
                q.pop_front();
                cnt++;
            }
            else {
                q.push_front(q.back());
                q.pop_back();
                cnt++;
            }
        }
        ans += min(cnt, (int)q.size() - cnt);
        q.pop_front();
    }
    cout << ans << endl;
    return 0;
}