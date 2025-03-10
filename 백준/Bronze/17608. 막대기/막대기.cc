#include <iostream>
#include <vector>
using namespace std;

#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<int> bars(N);
    for (int i = 0; i < N; i++) {
        cin >> bars[i];
    }
    
    int visibleCount = 0;
    int currentMax = 0;
    for (int i = N - 1; i >= 0; i--) {
        if (bars[i] > currentMax) {
            visibleCount++;
            currentMax = bars[i];
        }
    }
    
    cout << visibleCount;
    return 0;
}