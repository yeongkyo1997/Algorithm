#include <iostream>
#include <vector>

using namespace std;

int N, M, r, c, d;
vector<vector<int>> room;

int dr[] = {-1, 0, 1, 0};
int dc[] = {0, 1, 0, -1};

int clean() {
    int cleaned = 0;
    int nr, nc, nd;
    bool flag;

    while (true) {
        // 현재 위치 청소
        if (room[r][c] == 0) {
            room[r][c] = 2;
            cleaned++;
        }

        flag = false;
        for (int i = 0; i < 4; ++i) {
            nd = (d + 3) % 4;
            nr = r + dr[nd];
            nc = c + dc[nd];

            if (room[nr][nc] == 0) {
                r = nr;
                c = nc;
                d = nd;
                flag = true;
                break;
            }
            d = nd;
        }

        if (!flag) {
            nr = r - dr[d];
            nc = c - dc[d];
            if (room[nr][nc] == 1) break;
            r = nr;
            c = nc;
        }
    }

    return cleaned;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> M;
    cin >> r >> c >> d;

    room = vector<vector<int>>(N, vector<int>(M));

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> room[i][j];
        }
    }

    cout << clean() << '\n';

    return 0;
}