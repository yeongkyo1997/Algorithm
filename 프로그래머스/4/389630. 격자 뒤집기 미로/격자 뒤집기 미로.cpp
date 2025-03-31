#include <iostream>
#include <vector>
#include <array>
#include <algorithm>
#include <climits>

using namespace std;

long long calculate(const vector<vector<int>> &matrix, const vector<vector<int>> &hidden,
                    int n, int m, int k, bool isAllEven)
{

    vector<array<long long, 2>> colSum(m, {0LL, 0LL});
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            colSum[j][0] += matrix[i][j];
            colSum[j][1] += hidden[i][j];
        }
    }

    long long res = 0;
    for (int j = 0; j < m; j++)
    {
        res += max(colSum[j][0], colSum[j][1] - k);
    }

    if (isAllEven)
    {
        long long mn = LLONG_MAX;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if ((i + j) % 2 == 0)
                    continue;
                long long val = 0;
                if (colSum[j][0] == colSum[j][1] - k)
                {
                    val = min((long long)matrix[i][j], (long long)hidden[i][j]);
                }
                else if (colSum[j][0] > colSum[j][1] - k)
                {
                    val = matrix[i][j];
                }
                else
                {
                    val = hidden[i][j];
                }
                mn = min(mn, val);
            }
        }
        res -= mn;
    }

    return res;
}

long long solution(vector<vector<int>> visible, vector<vector<int>> hidden, int k)
{
    int n = visible.size();
    int m = visible[0].size();
    bool isAllEven = (n % 2 == 0) && (m % 2 == 0);

    int cases = 1 << n;
    long long res = 0;
    for (int mask = 0; mask < cases; mask++)
    {
        int cost = 0;

        for (int row = 0; row < n; row++)
        {
            if (mask & (1 << row))
            {
                swap(visible[row], hidden[row]);
                cost += k;
            }
        }

        long long curr = calculate(visible, hidden, n, m, k, isAllEven) - cost;
        res = max(res, curr);

        for (int row = 0; row < n; row++)
        {
            if (mask & (1 << row))
            {
                swap(visible[row], hidden[row]);
            }
        }
    }

    return res;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, k;
    cin >> n >> m >> k;

    vector<vector<int>> visible(n, vector<int>(m));
    vector<vector<int>> hidden(n, vector<int>(m));

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> visible[i][j];
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> hidden[i][j];
        }
    }

    cout << solution(visible, hidden, k) << "\n";

    return 0;
}
