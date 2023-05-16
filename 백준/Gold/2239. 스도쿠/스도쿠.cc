#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> sudoku(9, vector<int>(9));
bool flag = false;

bool check(int x, int y, int idx) {
    for (int i = 0; i < 9; i++) {
        if (sudoku[x][i] == idx) return false;
    }
    for (int i = 0; i < 9; i++) {
        if (sudoku[i][y] == idx) return false;
    }
    for (int i = x - x % 3; i < x - x % 3 + 3; i++) {
        for (int j = y - y % 3; j < y - y % 3 + 3; j++) {
            if (sudoku[i][j] == idx) return false;
        }
    }
    return true;
}

void game(int x, int y) {
    if (y == 9) {
        x++;
        y = 0;
    }
    if (x == 9) {
        flag = true;
        return;
    }
    if (sudoku[x][y] != 0) {
        game(x, y + 1);
    }
    else {
        for (int i = 1; i <= 9; i++) {
            if (!check(x, y, i)) continue;
            sudoku[x][y] = i;
            game(x, y + 1);
            if (flag) return;
            sudoku[x][y] = 0;
        }
    }
}

int main() {
    for (int i = 0; i < 9; i++) {
        string str;
        cin >> str;
        for (int j = 0; j < 9; j++) {
            sudoku[i][j] = str[j] - '0';
        }
    }

    game(0, 0);

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            cout << sudoku[i][j];
        }
        cout << '\n';
    }

    return 0;
}