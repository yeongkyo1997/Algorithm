#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int T;
    cin >> T;
    while (T--) {
        int x1, y1, x2, y2, n;
        cin >> x1 >> y1 >> x2 >> y2 >> n;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int cx, cy, cr;
            cin >> cx >> cy >> cr;
            int dis1 = pow(x1 - cx, 2) + pow(y1 - cy, 2);
            int dis2 = pow(x2 - cx, 2) + pow(y2 - cy, 2);
            int pow_cr = pow(cr, 2);
            if (pow_cr > dis1 && pow_cr > dis2) {
                // do nothing
            } else if (pow_cr > dis1) {
                count++;
            } else if (pow_cr > dis2) {
                count++;
            }
        }
        cout << count << endl;
    }
    return 0;
}