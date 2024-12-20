#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int n, m, a[501][501], result;
bool check[501][501];
int dx[] = {0, 0, 1, -1};
int dy[] = {-1, 1, 0, 0};

int ex[4][4] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
int ey[4][4] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};

void dfs(int x, int y, int sum_value, int length) {
    if (length >= 4) {
        result = max(result, sum_value);
        return;
    }

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 1 || nx > n || ny < 1 || ny > m)
            continue;

        if (!check[nx][ny]) {
            check[nx][ny] = true;
            dfs(nx, ny, sum_value + a[nx][ny], length + 1);
            check[nx][ny] = false;
        }
    }
}

void check_exshape(int x, int y) {
    for (int i = 0; i < 4; i++) {
        bool isOut = false;
        int sum_value = 0;

        for (int j = 0; j < 4; j++) {
            int nx = x + ex[i][j];
            int ny = y + ey[i][j];

            if (nx < 1 || nx > n || ny < 1 || ny > m) {
                isOut = true;
                break;
            } else {
                sum_value += a[nx][ny];
            }
        }

        if (!isOut) {
            result = max(result, sum_value);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;

    memset(check, false, sizeof(check));

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> a[i][j];
        }
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            check[i][j] = true;
            dfs(i, j, a[i][j], 1);
            check[i][j] = false;
            check_exshape(i, j);
        }
    }

    cout << result << "\n";

    return 0;
}
