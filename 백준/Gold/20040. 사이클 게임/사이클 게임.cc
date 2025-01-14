#include <bits/stdc++.h>
using namespace std;

struct DSU
{
    vector<int> parent, rank;

    DSU(int n) : parent(n), rank(n, 1)
    {
        for (int i = 0; i < n; i++)
        {
            parent[i] = i;
        }
    }

    int find_set(int x)
    {
        return x == parent[x] ? x : parent[x] = find_set(parent[x]);
    }

    bool union_set(int a, int b)
    {
        a = find_set(a);
        b = find_set(b);
        if (a == b)
            return false;
        if (rank[a] < rank[b])
            swap(a, b);
        parent[b] = a;
        if (rank[a] == rank[b])
            rank[a]++;
        return true;
    }
};

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int N, M;
    cin >> N >> M;

    DSU dsu(N);

    bool isCycle = false;
    int cnt = 0;

    for (int i = 1; i <= M; ++i)
    {
        int a, b;
        cin >> a >> b;
        if (!isCycle)
        {
            if (!dsu.union_set(a, b))
            {
                isCycle = true;
                cnt = i;
            }
        }
    }

    if (isCycle)
        cout << cnt << '\n';
    else
        cout << "0\n";

    return 0;
}