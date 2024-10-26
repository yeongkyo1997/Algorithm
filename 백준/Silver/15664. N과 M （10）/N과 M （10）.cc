#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int N, M;
set<vector<int>> s;
vector<int> arr;
void dfs(int depth, int start, vector<int> path)
{
    if (depth == M)
    {
        s.insert(path);
        return;
    }
    for (int i = start; i < N; i++)
    {
        path.push_back(arr[i]);
        dfs(depth + 1, i + 1, path);
        path.pop_back();
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        int num;
        cin >> num;
        arr.push_back(num);
    }
    sort(arr.begin(), arr.end());

    dfs(0, 0, {});
    vector<vector<int>> result(s.begin(), s.end());
    sort(result.begin(), result.end());

    for (vector<int> v : result)
    {
        for (int e : v)
        {
            cout << e << " ";
        }
        cout << "\n";
    }
}