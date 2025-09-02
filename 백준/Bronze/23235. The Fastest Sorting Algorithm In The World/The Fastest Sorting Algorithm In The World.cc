#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, x, caseNo = 1;
    while (cin >> N) {
        if (N == 0) break;
        for (int i = 0; i < N; ++i) cin >> x; // 값은 읽기만 하고 무시
        cout << "Case " << caseNo++ << ": Sorting... done!\n";
    }
    return 0;
}