#include <iostream>

#include <iomanip>

#include <algorithm>

using namespace std;

int R1, C1, R2, C2;

int GetValue(int r, int c) {
    int n = max(abs(r), abs(c));

    int last = (2 * n + 1) * (2 * n + 1);

    if (r == n)

        return last - (n - c);

    else if (c == -n)

        return last - (2 * n) - (n - r);

    else if (r == -n)

        return last - (4 * n) - (n + c);

    else

        return last - (6 * n) - (n + r);
}

int GetNumberOfDigit(int value) {

    return (value ? GetNumberOfDigit(value / 10) + 1 : 0);
}

int main() {
    ios::sync_with_stdio(false);

    cout.tie(nullptr);

    cout.tie(nullptr);

    cin >> R1 >> C1 >> R2 >> C2;

    int w = 0;

    for (int r = R1; r <= R2; ++r) {
        for (int c = C1; c <= C2; ++c)
            w = max(w, GetNumberOfDigit(GetValue(r, c)));
    }

    for (int r = R1; r <= R2; ++r) {
        for (int c = C1; c <= C2; ++c)
            cout << setw(w) << GetValue(r, c) << ' ';

        cout << '\n';
    }
}