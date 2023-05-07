#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    int p[1001];
    int ans = 0;

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> p[i];
    }

    sort(p, p+n);

    for (int i = 0; i < n; i++) {
        ans += p[i] * (n-i);
    }

    cout << ans << '\n';

    return 0;
}