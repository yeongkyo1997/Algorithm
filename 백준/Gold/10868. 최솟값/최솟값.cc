#include <bits/stdc++.h>
using namespace std;

int N, M;
vector<int> arr;
vector<int> tree;

void build(int node, int start, int end)
{
    if (start == end)
    {
        tree[node] = arr[start];
        return;
    }

    int mid = (start + end) / 2;

    build(node * 2, start, mid);
    build(node * 2 + 1, mid + 1, end);

    tree[node] = min(tree[node * 2], tree[node * 2 + 1]);
}

int query(int left, int right, int node, int start, int end)
{
    if (right < start || end < left)
    {
        return INT_MAX;
    }

    if (left <= start && end <= right)
    {
        return tree[node];
    }

    int mid = (start + end) / 2;
    return min(query(left, right, node * 2, start, mid), query(left, right, node * 2 + 1, mid + 1, end));
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    arr.resize(N);
    tree.resize(4 * N);

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    build(1, 0, N - 1);

    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        cout << query(a - 1, b - 1, 1, 0, N - 1) << "\n";
    }

    return 0;
}