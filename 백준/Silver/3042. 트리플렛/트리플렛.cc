#include <bits/stdc++.h>
using namespace std;

bool areCollinear(int y1, int x1, int y2, int x2, int y3, int x3)
{
    long long determinant = (long long)x1 * (y2 - y3) +
                            (long long)x2 * (y3 - y1) +
                            (long long)x3 * (y1 - y2);
    return determinant == 0;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;
    vector<string> grid(N);
    for (int i = 0; i < N; i++)
    {
        cin >> grid[i];
    }

    vector<pair<int, int>> letters;
    for (int y = 0; y < N; y++)
    {
        for (int x = 0; x < N; x++)
        {
            if (grid[y][x] != '.')
            {
                letters.emplace_back(y, x);
            }
        }
    }

    int n = letters.size();
    int result = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            for (int k = j + 1; k < n; k++)
            {
                int y1 = letters[i].first, x1 = letters[i].second;
                int y2 = letters[j].first, x2 = letters[j].second;
                int y3 = letters[k].first, x3 = letters[k].second;

                if (areCollinear(y1, x1, y2, x2, y3, x3))
                {
                    result++;
                }
            }
        }
    }

    cout << result;
}