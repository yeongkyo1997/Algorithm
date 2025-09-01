#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    auto score = [](int T, int F, int S, int P, int C) {
        return 6*T + 3*F + 2*S + P + 2*C;
    };
    int Tv, Fv, Sv, Pv, Cv;
    int Th, Fh, Sh, Ph, Ch;
    if (!(cin >> Tv >> Fv >> Sv >> Pv >> Cv)) return 0;
    cin >> Th >> Fh >> Sh >> Ph >> Ch;
    cout << score(Tv, Fv, Sv, Pv, Cv) << ' ' << score(Th, Fh, Sh, Ph, Ch) << '\n';
    return 0;
}