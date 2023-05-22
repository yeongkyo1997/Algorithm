#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int n;
int ans_max;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
vector<vector<int>> board;

int cal() {
    int max_value = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            max_value = max(max_value, board[i][j]);
        }
    }
    return max_value;
}

void up() {
    for (int col = 0; col < n; col++) {
        vector<int> tmp;
        for (int row = 0; row < n; row++) {
            if (board[row][col] != 0) {
                tmp.push_back(board[row][col]);
                board[row][col] = 0;
            }
        }
        int idx = 0;
        for (int row = 0; row < n; row++) {
            if (tmp.empty()) break;
            int val = tmp.front();
            tmp.erase(tmp.begin());
            if (!tmp.empty() && val == tmp.front()) {
                tmp.erase(tmp.begin());
                board[row][col] = val * 2;
            } else {
                board[row][col] = val;
            }
            idx++;
        }
    }
}

void down() {
    for(int col = 0; col < n; col++) {
        vector<int> tmp;
        for(int row = n-1; row >= 0; row--) {
            if(board[row][col] != 0) {
                tmp.push_back(board[row][col]);
                board[row][col] = 0;
            }
        }
        int idx = 0;
        for(int row = n-1; row >= 0; row--) {
            if(tmp.empty()) break;
            int val = tmp.front();
            tmp.erase(tmp.begin());
            if(!tmp.empty() && val == tmp.front()) {
                tmp.erase(tmp.begin());
                board[row][col] = val * 2;
            } else {
                board[row][col] = val;
            }
            idx++;
        }
    }
}

void left() {
    for(int row = 0; row < n; row++) {
        vector<int> tmp;
        for(int col = 0; col < n; col++) {
            if(board[row][col] != 0) {
                tmp.push_back(board[row][col]);
                board[row][col] = 0;
            }
        }
        int idx = 0;
        for(int col = 0; col < n; col++) {
            if(tmp.empty()) break;
            int val = tmp.front();
            tmp.erase(tmp.begin());
            if(!tmp.empty() && val == tmp.front()) {
                tmp.erase(tmp.begin());
                board[row][col] = val * 2;
            } else {
                board[row][col] = val;
            }
            idx++;
        }
    }
}

void right() {
    for(int row = 0; row < n; row++) {
        vector<int> tmp;
        for(int col = n-1; col >= 0; col--) {
            if(board[row][col] != 0) {
                tmp.push_back(board[row][col]);
                board[row][col] = 0;
            }
        }
        int idx = 0;
        for(int col = n-1; col >= 0; col--) {
            if(tmp.empty()) break;
            int val = tmp.front();
            tmp.erase(tmp.begin());
            if(!tmp.empty() && val == tmp.front()) {
                tmp.erase(tmp.begin());
                board[row][col] = val * 2;
            } else {
                board[row][col] = val;
            }
            idx++;
        }
    }
}

void dfs(int count) {
    if(count == 5) {
        ans_max = max(ans_max, cal());
        return;
    }
    vector<vector<int>> origin = board;

    up();
    dfs(count + 1);
    board = origin;

    down();
    dfs(count + 1);
    board = origin;

    left();
    dfs(count + 1);
    board = origin;

    right();
    dfs(count + 1);
    board = origin;
}

int main() {
    cin >> n;
    board.resize(n, vector<int>(n));
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> board[i][j];
        }
    }

    ans_max = 0;
    dfs(0);
    cout << ans_max << '\n';
}