#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

void dfs(vector<int> &arr, int *path, int depth, int M, int flag, int N)
{
    if (depth == M)
    {
        for (int i = 0; i < M; i++)
        {
            cout << path[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 0; i < N; ++i)
    {
        if ((flag & (1 << i)) == 0)
        {
            path[depth] = arr[i];
            dfs(arr, path, depth + 1, M, flag | (1 << i), N);
        }
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<int> arr(N);
    for (int i = 0; i < N; ++i)
    {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end());

    int path[100];
    dfs(arr, path, 0, M, 0, N);

    return 0;
}