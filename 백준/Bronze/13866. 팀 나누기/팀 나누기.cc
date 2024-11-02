#include <iostream>
#include <vector>

using namespace std;

int dfs(int depth, vector<int> &arr, int flag)
{
    if (depth == 2)
    {
        int teamA = 0, teamB = 0;
        for (int i = 0; i < arr.size(); i++)
        {
            if (flag & (1 << i))
            {
                teamA += arr[i];
            }
            else
            {
                teamB += arr[i];
            }
        }
        return abs(teamA - teamB);
    }

    int ret = 1 << 30;

    for (int i = 0; i < arr.size(); i++)
    {
        if (flag & (1 << i))
            continue;

        ret = min(ret, dfs(depth + 1, arr, flag | (1 << i)));
    }

    return ret;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    vector<int> arr(4);

    for (int i = 0; i < 4; i++)
    {
        cin >> arr[i];
    }

    cout << dfs(0, arr, 0);
}