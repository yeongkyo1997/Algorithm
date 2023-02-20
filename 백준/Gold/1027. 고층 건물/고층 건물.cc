#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <cstring>

using namespace std;
const double inf = 1.0 * 1000000001;
int n, height[51], chk[51][51];

int main() {
	cin >> n;

    for (int i = 0; i < n; ++i)
        cin >> height[i];

    int ret = 0;

    for (int i = 0; i < n; ++i) {
		double mtan = -inf;

		int cnt = 0;

		for (int j = i + 1; j < n; ++j) {
            double ttan = 1.0 * (height[j] - height[i]) / (j - i);

            if (mtan < ttan)
				mtan = ttan, ++cnt, chk[i][j] = true;
		}

		for (int j = 0; j < i; ++j)
            if (chk[j][i])
                ++cnt;
                
        ret = max(ret, cnt);
    }
	cout << ret << '\n';
	return 0;
}