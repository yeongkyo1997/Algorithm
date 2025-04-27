#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);  // C 스타일 I/O 비동기 해제
    cin.tie(nullptr);             // cin과 cout 연결 해제

    int D, K;
    cin >> D >> K;

    // 피보나치 수열 F: F[1]=1, F[2]=1, F[n]=F[n-1]+F[n-2]
    vector<int> F(D + 1);
    F[1] = 1;
    F[2] = 1;
    for (int i = 3; i <= D; i++) {
        F[i] = F[i - 1] + F[i - 2];
    }

    int A = 0, B = 0;
    // S[D] = F[D-2] * A + F[D-1] * B = K 인 정수 해 찾기
    // A는 1부터 시작, B = (K - F[D-2]*A) / F[D-1]
    for (int a = 1; a <= K; a++) {
        int rem = K - F[D-2] * a;
        if (rem <= 0) break;  // B가 음수가 되면 더 이상 의미 없음
        if (rem % F[D-1] == 0) {
            int b = rem / F[D-1];
            if (b >= a) {      // 문제에서 1 ≤ A ≤ B 조건
                A = a;
                B = b;
                break;
            }
        }
    }

    // 결과 출력
    cout << A << "\n";
    cout << B << "\n";
    return 0;
}
