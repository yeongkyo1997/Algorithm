#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    long long B, C;
    cin >> N >> B >> C;

    vector<long long> A(N + 3, 0);
    for (int i = 1; i <= N; i++) {
        cin >> A[i];
    }

    long long cost = 0;

    // C >= B 인 경우, 묶음 구매가 싱글보다 비싸거나 같으므로 모두 싱글로 구매
    if (C >= B) {
        for (int i = 1; i <= N; i++) {
            cost += A[i] * B;
        }
        cout << cost << "\n";
        return 0;
    }

    // C < B 인 경우, 묶음 구매 활용
    for (int i = 1; i <= N; i++) {
        // (i, i+1) vs (i, i+1, i+2)에 최적 순서 결정
        // A[i+1] > A[i+2] 이면 페어 우선
        if (A[i+1] > A[i+2]) {
            long long t2 = min(A[i], A[i+1] - A[i+2]);
            cost += t2 * (B + C);
            A[i]     -= t2;
            A[i+1]   -= t2;
        }
        // 트리플 구매
        long long t3 = min({A[i], A[i+1], A[i+2]});
        cost += t3 * (B + 2*C);
        A[i]     -= t3;
        A[i+1]   -= t3;
        A[i+2]   -= t3;

        // 페어 구매
        long long t2 = min(A[i], A[i+1]);
        cost += t2 * (B + C);
        A[i]     -= t2;
        A[i+1]   -= t2;

        // 남은 것은 모두 싱글 구매
        cost += A[i] * B;
        A[i] = 0;
    }

    cout << cost << "\n";
    return 0;
}
