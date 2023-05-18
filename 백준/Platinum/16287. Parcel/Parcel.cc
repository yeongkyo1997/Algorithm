#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int w, n;
    cin >> w >> n;
    int a[n];
    unordered_map<int, pair<int, int>> pairs;

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    sort(a, a + n);

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int current_sum = a[i] + a[j];
            if (pairs.count(w - current_sum)) {
                auto& pair = pairs[w - current_sum];
                if (pair.first != i && pair.first != j && pair.second != i && pair.second != j) {
                    cout << "YES\n";
                    return 0;
                }
            }
        }

        for (int j = 0; j < i; j++) {
            pairs[a[i] + a[j]] = {j, i};
        }
    }

    cout << "NO\n";
    return 0;
}