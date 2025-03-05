#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<int> A(n);
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }

    // 각 인덱스 i에 대해 A[0..i]까지의 증가하는 부분수열의 최대 길이
    vector<int> dp_inc(n, 1);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (A[i] > A[j]) {
                dp_inc[i] = max(dp_inc[i], dp_inc[j] + 1);
            }
        }
    }

    // 각 인덱스 i에 대해 A[i..n-1]까지의 감소하는 부분수열의 최대 길이
    vector<int> dp_dec(n, 1);
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i + 1; j < n; j++) {
            if (A[i] > A[j]) {
                dp_dec[i] = max(dp_dec[i], dp_dec[j] + 1);
            }
        }
    }

    // 바이토닉 수열은 증가 부분과 감소 부분이 겹치는 중앙 요소를 가지므로
    // 두 길이를 더한 후 중앙 중복을 제거하기 위해 1을 빼줍니다.
    int ans = 0;
    for (int i = 0; i < n; i++) {
        ans = max(ans, dp_inc[i] + dp_dec[i] - 1);
    }

    cout << ans << "\n";
    return 0;
}