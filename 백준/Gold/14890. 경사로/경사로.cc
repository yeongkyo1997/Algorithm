#include <bits/stdc++.h>
using namespace std;

int N, L;
int a[100][100];

// 특정 경로(arr)가 지나갈 수 있는지 검사하는 함수
bool can_pass(const vector<int>& arr) {
    vector<bool> used(N, false); // 경사로를 놓았는지 표시
    for (int i = 0; i < N - 1; ++i) {
        int h = arr[i], nh = arr[i + 1];
        if (h == nh) {
            // 높이 같으면 문제 없음
            continue;
        }
        // 높이 차이가 1 이상이면 불가능
        if (abs(h - nh) > 1) return false;

        // 오르막 (다음이 더 높음)
        if (h + 1 == nh) {
            // 이전 L칸이 모두 h이고, 아직 경사로 사용 안 했는지 확인
            for (int j = i; j > i - L; --j) {
                if (j < 0 || arr[j] != h || used[j]) return false;
                used[j] = true;
            }
        }
        // 내리막 (다음이 더 낮음)
        else if (h - 1 == nh) {
            // 다음 L칸이 모두 nh이고, 아직 경사로 사용 안 했는지 확인
            for (int j = i + 1; j <= i + L; ++j) {
                if (j >= N || arr[j] != nh || used[j]) return false;
                used[j] = true;
            }
        }
    }
    return true;
}

int main() {
    // 빠른 입출력 설정
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> L;
    for (int i = 0; i < N; ++i)
        for (int j = 0; j < N; ++j)
            cin >> a[i][j];

    int result = 0;
    // 모든 행 검사
    for (int i = 0; i < N; ++i) {
        vector<int> row(N);
        for (int j = 0; j < N; ++j) row[j] = a[i][j];
        if (can_pass(row)) result++;
    }
    // 모든 열 검사
    for (int j = 0; j < N; ++j) {
        vector<int> col(N);
        for (int i = 0; i < N; ++i) col[i] = a[i][j];
        if (can_pass(col)) result++;
    }

    cout << result << "\n";
    return 0;
}
