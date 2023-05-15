#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Tomato {
public:
    int x, y, z;

    Tomato(int z, int x, int y) : z(z), x(x), y(y) {}
};

int M, N, H;
int dx[] = {-1, 0, 1, 0, 0, 0};
int dy[] = {0, 1, 0, -1, 0, 0};
int dz[] = {0, 0, 0, 0, 1, -1};

vector<vector<vector<int>>> board;
queue<Tomato> que;

int BFS() {
    while (!que.empty()) {
        Tomato t = que.front();
        que.pop();

        int z = t.z;
        int x = t.x;
        int y = t.y;

        for (int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nz = z + dz[i];

            if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
                if (board[nz][nx][ny] == 0) {
                    que.push(Tomato(nz, nx, ny));
                    board[nz][nx][ny] = board[z][x][y] + 1;
                }
            }
        }
    }

    int result = -1;

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (board[i][j][k] == 0) return -1;
                result = max(result, board[i][j][k]);
            }
        }
    }

    if (result == 1) return 0;
    else return result - 1;
}

int main() {
    cin >> M >> N >> H;

    board.resize(H, vector<vector<int>>(N, vector<int>(M)));

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                cin >> board[i][j][k];
                if (board[i][j][k] == 1) que.push(Tomato(i, j, k));
            }
        }
    }

    cout << BFS() << endl;

    return 0;
}