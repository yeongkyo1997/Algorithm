#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n;
    cin >> n;
    
    vector<int> A(n), B(n), C(n), D(n);
    for (int i = 0; i < n; ++i)
        cin >> A[i] >> B[i] >> C[i] >> D[i];
    
    vector<int> AB_sum;
    AB_sum.reserve(n * n);
    for (int a : A)
        for (int b : B)
            AB_sum.push_back(a + b);
    
    sort(AB_sum.begin(), AB_sum.end());
    
    long long cnt = 0;
    for (int c : C) {
        for (int d : D) {
            int target = -(c + d);
            auto range = equal_range(AB_sum.begin(), AB_sum.end(), target);
            cnt += range.second - range.first;
        }
    }
    
    cout << cnt;
    return 0;
}