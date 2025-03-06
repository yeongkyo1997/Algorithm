#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;
    vector<int> D(N-1);
    for (int& d : D) {
        cin >> d;
    }
    
    vector<long long> prefix(N);
    prefix[0] = 0;
    for (int i = 1; i < N; ++i) {
        prefix[i] = prefix[i-1] + D[i-1];
    }
    
    long long min_s = *min_element(prefix.begin(), prefix.end());
    long long max_s = *max_element(prefix.begin(), prefix.end());
    
    long long lower = max(1LL, 1LL - min_s);
    long long upper = min((long long)N, (long long)N - max_s);
    
    if (lower > upper) {
        cout << -1;
    } else if (upper - lower + 1 != 1) {
        cout << -1;
    } else {
        long long A1 = lower;
        vector<long long> A(N);
        bool valid = true;
        for (int i = 0; i < N; ++i) {
            A[i] = A1 + prefix[i];
            if (A[i] < 1 || A[i] > N) {
                valid = false;
                break;
            }
        }
        if (!valid) {
            cout << -1;
        } else {
            for (long long num : A) {
                cout << num << ' ';
            }
        }
    }
    
    return 0;
}