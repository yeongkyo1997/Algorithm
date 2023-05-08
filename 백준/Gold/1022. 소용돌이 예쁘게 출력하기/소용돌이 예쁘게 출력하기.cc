#include <iostream>
#include <iomanip>
#include <cmath>
#include <algorithm>
using namespace std;

int calculate(int row, int column) {
    int border = max(abs(row), abs(column));
    int min_val = pow(2 * border - 1, 2) + 1;

    if (row == border) {
        return min_val + 7 * border - 1 + column;
    }

    if (column == -border) {
        return min_val + 5 * border - 1 + row;
    }

    if (row == -border) {
        return min_val + 3 * border - 1 - column;
    }

    return min_val + border - 1 - row;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int r1, c1, r2, c2;
    cin >> r1 >> c1 >> r2 >> c2;

    int vortex[r2 - r1 + 1][c2 - c1 + 1];
    int max_val = 0;
    for (int i = r1; i <= r2; i++) {
        for (int j = c1; j <= c2; j++) {
            vortex[i - r1][j - c1] = calculate(i, j);
            max_val = max(max_val, vortex[i - r1][j - c1]);
        }
    }

    int max_len = to_string(max_val).length();

    for (int i = 0; i <= r2 - r1; i++) {
        for (int j = 0; j <= c2 - c1; j++) {
            cout << setw(max_len) << vortex[i][j];
            if (j != c2 - c1) cout << ' ';
        }
        cout << '\n';
    }

    return 0;
}
