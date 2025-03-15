#include <iostream>
#include <cstring>
using namespace std;

int board[9][9];
bool row[9][9] = {false};
bool col[9][9] = {false};
bool grid[3][3][9] = {false};

bool solve(int i, int j) {
    if (i == 9) return true;
    if (j == 9) return solve(i + 1, 0);
    if (board[i][j] != 0) return solve(i, j + 1);
    
    int gi = i / 3, gj = j / 3;
    for (int num = 1; num <= 9; ++num) {
        int idx = num - 1;
        if (!row[i][idx] && !col[j][idx] && !grid[gi][gj][idx]) {
            row[i][idx] = col[j][idx] = grid[gi][gj][idx] = true;
            board[i][j] = num;
            if (solve(i, j + 1)) return true;
            board[i][j] = 0;
            row[i][idx] = col[j][idx] = grid[gi][gj][idx] = false;
        }
    }
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    for (int i = 0; i < 9; ++i) {
        string s;
        cin >> s;
        for (int j = 0; j < 9; ++j) {
            board[i][j] = s[j] - '0';
            int num = board[i][j];
            if (num != 0) {
                int idx = num - 1;
                row[i][idx] = true;
                col[j][idx] = true;
                grid[i/3][j/3][idx] = true;
            }
        }
    }
    
    solve(0, 0);
    
    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < 9; ++j) {
            cout << board[i][j];
        }
        cout << '\n';
    }
    
    return 0;
}