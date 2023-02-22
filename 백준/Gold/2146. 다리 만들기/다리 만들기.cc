#include <iostream>
#include <algorithm>


using namespace std;

int n;
int Map[100][100];
int label = 2;
bool IsCoast[100][100];
int best = 1000;

const int Adj[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };


void dfs(int i, int j) {
    Map[i][j] = label;

    int r, c;
    for (int k = 0; k < 4; k++) {
        r = i + Adj[k][0];
        c = j + Adj[k][1];
        if (r < 0 || r >= n || c < 0 || c >= n)
            continue;
        if (Map[r][c] == 0)
            IsCoast[i][j] = true;
        if (Map[r][c] == 1)
            dfs(r, c);
    }
}


int main(void) {
    cin >> n;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> Map[i][j];

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            if (Map[i][j] == 1) {
                dfs(i, j);
                label++;
            }

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            if (IsCoast[i][j])
                for (int ii = i; ii <= min(n - 1, i + best); ii++)
                    for (int jj = max(0, j - best); jj <= min(n - 1, j + best); jj++)
                        if (Map[i][j] != Map[ii][jj] && IsCoast[ii][jj])
                            best = min(best, abs(i - ii) + abs(j - jj) - 1);
    cout << best;

    return 0;
}