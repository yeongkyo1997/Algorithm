#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int N, K, L;
int map[101][101] = {0};
int dx[] = {0, 1, 0, -1}; 
int dy[] = {1, 0, -1, 0};

int main() {
    cin >> N >> K;

    int x, y;
    for (int i = 0; i < K; i++) {
        cin >> x >> y;
        map[x][y] = 1; 
    }

    cin >> L;
    queue<pair<int, char>> moves;
    int t;
    char c;
    for (int i = 0; i < L; i++) {
        cin >> t >> c;
        moves.push(make_pair(t, c));
    }

    int time = 0, direction = 0;
    x = 1, y = 1;
    queue<pair<int, int>> snake;
    snake.push(make_pair(x, y));
    map[x][y] = 2; 

    while (true) {
        time++;
        int nx = x + dx[direction];
        int ny = y + dy[direction];

        if (nx < 1 || ny < 1 || nx > N || ny > N || map[nx][ny] == 2) {
            break;
        }

        if (map[nx][ny] != 1) {
            int tx = snake.front().first;
            int ty = snake.front().second;
            snake.pop();
            map[tx][ty] = 0;
        }

        map[nx][ny] = 2;
        snake.push(make_pair(nx, ny));

        x = nx;
        y = ny;

        if (!moves.empty() && moves.front().first == time) {
            if (moves.front().second == 'D') {
                direction = (direction + 1) % 4;
            } else {
                direction = (direction + 3) % 4;
            }
            moves.pop();
        }
    }

    cout << time << endl;
    return 0;
}