#include <iostream>
#include <vector>
using namespace std;

int white = 0;
int blue = 0;
vector<vector<int>> board;

void partition(int row, int col, int size) {
    int color = board[row][col];

    for (int i = row; i < row + size; i++) {
        for (int j = col; j < col + size; j++) {
            if (board[i][j] != color) {
                int newSize = size / 2;
                partition(row, col, newSize);
                partition(row, col + newSize, newSize);
                partition(row + newSize, col, newSize);
                partition(row + newSize, col + newSize, newSize);
                return;
            }
        }
    }

    if (color == 0)
        white++;
    else
        blue++;
}

int main() {
    int N;
    cin >> N;

    board = vector<vector<int>>(N, vector<int>(N));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }

    partition(0, 0, N);

    cout << white << endl;
    cout << blue << endl;

    return 0;
}