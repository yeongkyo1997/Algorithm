#include <bits/stdc++.h>
using namespace std;

int CCW(long long x1, long long y1, long long x2, long long y2, long long x3, long long y3) {
    long long result = ((x1 * y2) + (x2 * y3) + (x3 * y1)) - ((x2 * y1) + (x3 * y2) + (x1 * y3));

    if (result > 0) {
        return 1;
    } else if (result < 0) {
        return -1;
    } else {
        return 0;
    }
}

bool isOverlab(long long x1, long long y1, long long x2, long long y2, long long x3, long long y3, long long x4, long long y4) {
    if (min(x1, x2) <= max(x3, x4) && min(x3, x4) <= max(x1, x2) && min(y1, y2) <= max(y3, y4) && min(y3, y4) <= max(y1, y2)) {
        return true;
    } else {
        return false;
    }
}

bool isCross(long long x1, long long y1, long long x2, long long y2, long long x3, long long y3, long long x4, long long y4) {
    int ABC = CCW(x1, y1, x2, y2, x3, y3);
    int ABD = CCW(x1, y1, x2, y2, x4, y4);
    int CDA = CCW(x3, y3, x4, y4, x1, y1);
    int CDB = CCW(x3, y3, x4, y4, x2, y2);

    if (ABC * ABD == 0 && CDA * CDB == 0) {
        return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);
    } else if (ABC * ABD <= 0 && CDA * CDB <= 0) {
        return true;
    } else {
        return false;
    }
}

int main() {
    long long x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;
    long long x3, y3, x4, y4;
    cin >> x3 >> y3 >> x4 >> y4;

    if (isCross(x1, y1, x2, y2, x3, y3, x4, y4)) {
        cout << 1 << endl;
    } else {
        cout << 0 << endl;
    }

    return 0;
}