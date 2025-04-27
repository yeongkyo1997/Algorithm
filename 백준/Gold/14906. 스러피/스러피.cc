#include <bits/stdc++.h>
using namespace std;

string s;

// 스럼프 판정: s[i...]가 스럼프인지 판정하고, 맞으면 i를 끝 위치 다음으로 이동시킴
bool isSlump(int &i) {
    // 첫 글자는 D 또는 E
    if (i >= (int)s.size() || (s[i] != 'D' && s[i] != 'E')) return false;
    i++;
    // 하나 이상의 F
    int cntF = 0;
    while (i < (int)s.size() && s[i] == 'F') {
        i++;
        cntF++;
    }
    if (cntF < 1) return false;
    // F 뒤에는 G 혹은 또 다른 스럼프
    if (i < (int)s.size() && s[i] == 'G') {
        i++;
        return true;
    }
    // 아니면 재귀적으로 스럼프
    if (isSlump(i)) {
        return true;
    }
    return false;
}

// 슬림프 판정: s[i...]가 슬림프인지 판정하고, 맞으면 i를 끝 위치 다음으로 이동시킴
bool isSlimp(int &i) {
    // 첫 글자는 A
    if (i >= (int)s.size() || s[i] != 'A') return false;
    i++;
    // 길이 2인 경우: AH
    if (i < (int)s.size() && s[i] == 'H') {
        i++;
        return true;
    }
    // 그 외: 두 가지 형식
    // 1) A B 슬림프 C
    if (i < (int)s.size() && s[i] == 'B') {
        i++;
        if (!isSlimp(i)) return false;
        if (i >= (int)s.size() || s[i] != 'C') return false;
        i++;
        return true;
    }
    // 2) A 스럼프 C
    if (isSlump(i)) {
        if (i >= (int)s.size() || s[i] != 'C') return false;
        i++;
        return true;
    }
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<string> v(N);
    for (int i = 0; i < N; i++) {
        cin >> v[i];
    }

    cout << "SLURPYS OUTPUT\n";
    for (const auto &str : v) {
        s = str;
        int idx = 0;
        // 슬림프 + 스럼프 이면서 문자열을 정확히 모두 소모했는지 확인
        if (isSlimp(idx) && isSlump(idx) && idx == (int)s.size()) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
    cout << "END OF OUTPUT\n";
    return 0;
}
