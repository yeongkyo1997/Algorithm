#include <iostream>
#include <vector>

using namespace std;

int N, M;

void dfs(int depth, vector<int> path, int flag)
{
    if (depth == M)
    {
        for (int p : path)
        {
            cout << p << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 1; i <= N; i++)
    {
        if (flag & (1 << i))
            continue;

        path.push_back(i);
        dfs(depth + 1, path, flag | (1 << i));
        path.pop_back();
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    dfs(0, {}, 0);
}