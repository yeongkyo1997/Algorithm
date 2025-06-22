#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    const int OFFSET = 1000000;  
    const int MAXV = 2000000;    // –1,000,000…+1,000,000 → 인덱스 0…2,000,000
    vector<int> cnt(MAXV+1, 0);

    // 1) 입력을 받아 카운팅
    for (int i = 0, x; i < N; i++) {
        cin >> x;
        cnt[x + OFFSET]++;
    }

    // 2) 결과를 한 번에 모으기
    //    평균적으로 각 줄당 최대 9바이트 정도(예: "-1000000\n")라 잡고 reserve
    string output;
    output.reserve((size_t)N * 8);

    for (int i = 0; i <= MAXV; i++) {
        int c = cnt[i];
        if (c == 0) continue;

        int val = i - OFFSET;
        // 같은 수가 여러 번 중복될 수 있으므로
        // count만큼 반복해서 문자열에 붙여 준다.
        string s = to_string(val) + '\n';
        while (c--) {
            output += s;
        }
    }

    // 3) 한 번에 출력
    cout << output;

    return 0;
}