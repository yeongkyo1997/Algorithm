#include <bits/stdc++.h>

using namespace std;

vector<int> dx = {0, 0, -1, 1};
vector<int> dy = {-1, 1, 0, 0};
vector<vector<int>> arr;
int N;

int dfs(int x, int y)
{
    if (arr[x][y] == 0)
        return 0;

    arr[x][y] = 0;

    int result = 1;
    for (int d = 0; d < 4; d++)
    {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (0 <= nx && nx < N && 0 <= ny && ny < N)
        {
            result += dfs(nx, ny);
        }
    }

    return result;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin >> N;
    arr.resize(N, vector<int>(N));

    for (int i = 0; i < N; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < N; j++)
        {
            arr[i][j] = s[j] - '0';
        }
    }
    vector<int> result;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (arr[i][j] == 1)
                result.push_back(dfs(i, j));
        }
    }

    sort(result.begin(), result.end());

    cout << result.size() << '\n';
    for (auto r : result)
        cout << r << '\n';
}