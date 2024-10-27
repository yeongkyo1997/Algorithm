#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    vector<int> vec(N);

    for (int i = 0; i < N; i++) {
        cin >> vec[i];
    }

    // 수열 정렬
    sort(vec.begin(), vec.end());

    // 가장 작은 부분합으로 만들 수 없는 수 찾기
    int target = 1;

    for (int num : vec) {
        if (num > target) {
            // 현재 수가 target보다 크면 target은 만들 수 없는 값
            break;
        }
        target += num; // 현재 수를 포함한 누적합 범위를 확장
    }

    cout << target << endl;
    return 0;
}