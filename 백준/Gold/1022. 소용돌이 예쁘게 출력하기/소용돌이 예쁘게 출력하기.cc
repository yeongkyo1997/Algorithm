#include <bits/stdc++.h>
#include <iomanip>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    long long r1, c1, r2, c2;
    cin >> r1 >> c1 >> r2 >> c2;

    int n_rows = r2 - r1 + 1;
    int n_cols = c2 - c1 + 1;

    vector<vector<long long>> grid(n_rows, vector<long long>(n_cols, 0));
    long long max_num_in_grid = 1;

    for (int row = 0; row < n_rows; ++row)
    {
        long long r = r1 + row;
        for (int col = 0; col < n_cols; ++col)
        {
            long long c = c1 + col;
            long long k = max(abs(r), abs(c));
            long long num;
            if (k == 0)
            {
                num = 1;
            }
            else
            {
                long long max_num = (2 * k + 1) * (2 * k + 1);
                if (r == k)
                {
                    num = max_num - (k - c);
                }
                else if (c == -k)
                {
                    num = max_num - 2 * k - (k - r);
                }
                else if (r == -k)
                {
                    num = max_num - 4 * k - (k + c);
                }
                else if (c == k)
                {
                    num = max_num - 6 * k - (k + r);
                }
                else
                {
                    // This should not happen as k = max(abs(r), abs(c))
                    num = 1;
                }
            }
            grid[row][col] = num;
            if (num > max_num_in_grid)
            {
                max_num_in_grid = num;
            }
        }
    }

    int len = to_string(max_num_in_grid).size();

    for (int row = 0; row < n_rows; ++row)
    {
        for (int col = 0; col < n_cols; ++col)
        {
            if (col != 0)
            {
                cout << ' ';
            }
            cout << right << setw(len) << grid[row][col];
        }
        cout << '\n';
    }
}