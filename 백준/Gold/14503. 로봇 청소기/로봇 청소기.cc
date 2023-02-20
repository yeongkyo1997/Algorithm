#include <iostream>
#include <algorithm>

using namespace std;

int n, m, a[51][51], x, y, h, r;
int dx[] = { 0,-1,0,1 };
int dy[] = { -1,0,1,0 };

int main() {
    cin >> n >> m;
	
	cin >> x >> y >> h;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
            cin >> a[i][j];
    }

    bool f = 1;

    while (f) {
        if (!a[x][y])
            r++;

        a[x][y] = 2;

        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                int cx = x + dx[(h + 3) % 4];
                int cy = y + dy[(h + 3) % 4];

                if (a[cx][cy] != 1) {
                    x = cx;
                    y = cy;
                }
                else
                    f = 0;
                
				break;
            }

            int cx = x + dx[h];
            int cy = y + dy[h];

            h = (h + 3) % 4;

            if (!a[cx][cy]) {
                x = cx;
                y = cy;
                break;
            }
        }
    }
    cout << r << "\n";
}