#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int H, W;
    cin >> H >> W;

    vector<string> S(H);
    for (int i = 0; i < H; i++) {
        cin >> S[i];
    }

    // C[j]: 현재 i보다 아래에 있는 행들 중에서 열 j에 'I'가 있는 개수
    vector<int> C(W, 0);
    // 초기화: i = 0일 때, 아래 행(1..H-1)에 있는 'I' 개수를 센다
    for (int i = 1; i < H; i++) {
        for (int j = 0; j < W; j++) {
            if (S[i][j] == 'I') C[j]++;
        }
    }

    long long total = 0;

    // 각 i 행을 윗행으로 고정 (i from 0 to H-2)
    for (int i = 0; i < H - 1; i++) {
        // R[j]: 행 i에서 열 j보다 오른쪽에 있는 'O' 개수
        vector<int> R(W, 0);
        // 맨 오른쪽엔 오른쪽에 아무것도 없으므로 0
        R[W-1] = 0;
        // 오른쪽부터 누적
        for (int j = W - 2; j >= 0; j--) {
            R[j] = R[j+1] + (S[i][j+1] == 'O');
        }

        // 열 j를 왼쪽 열로 고정
        for (int j = 0; j < W; j++) {
            // (i,j)에 'J' 있어야 하고, 오른쪽에 'O'가 R[j]개 있어야 함
            if (S[i][j] == 'J') {
                // C[j]: 아래쪽에 'I' 개수
                total += (long long) C[j] * R[j];
            }
        }

        // i가 한 단계 내려가면, 아래쪽 집합에서 S[i+1] 행을 제외해야 함
        for (int j = 0; j < W; j++) {
            if (S[i+1][j] == 'I') {
                C[j]--;
            }
        }
    }

    // 결과 출력
    cout << total << "\n";
    return 0;
}
