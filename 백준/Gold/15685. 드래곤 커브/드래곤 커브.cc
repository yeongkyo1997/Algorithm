#include <iostream>
#include <vector>

using namespace std;

const int N = 101;
int board[N][N] = {0};
vector<int> dir = {0, 1, 2, 3}; // (1, 0), (0, -1), (-1, 0), (0, 1)
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};

int main() {
    int curve_count;
    cin >> curve_count;

    for (int c = 0; c < curve_count; ++c) {
        int x, y, d, g;
        cin >> x >> y >> d >> g;

        vector<int> curve = {d};
        board[x][y] = 1;

        for (int gen = 0; gen < g; ++gen) {
            for (int i = curve.size() - 1; i >= 0; --i) {
                curve.push_back((curve[i] + 1) % 4);
            }
        }

        for (int i : curve) {
            x += dx[i];
            y += dy[i];
            if (0 <= x && x < N && 0 <= y && y < N) {
                board[x][y] = 1;
            }
        }
    }

    int result = 0;
    for (int i = 0; i < N - 1; ++i) {
        for (int j = 0; j < N - 1; ++j) {
            if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
                result++;
            }
        }
    }

    cout << result << endl;

    return 0;
}