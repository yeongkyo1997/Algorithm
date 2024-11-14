#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N;
    cin >> N;
    if (N <= 0)
    {
        cout << 0;
        return 0;
    }
    ll total = 0;
    function<void(int, int, int, int)> backtrack = [&](int row, int columns, int diag1, int diag2)
    {
        if (row == N)
        {
            total++;
            return;
        }
        int available = ~(columns | diag1 | diag2) & ((1 << N) - 1);
        while (available)
        {
            int pos = available & -available;
            available -= pos;
            backtrack(row + 1, columns | pos, (diag1 | pos) << 1, (diag2 | pos) >> 1);
        }
    };
    backtrack(0, 0, 0, 0);
    cout << total;
}