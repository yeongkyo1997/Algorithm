#include <bits/stdc++.h>
using namespace std;

static const int MAXN = 100000;

int n, m;
int arr[MAXN + 1];

vector<int> tree[4 * MAXN];

void build(int node, int start, int end)
{
    if (start == end)
    {

        tree[node].push_back(arr[start]);
        return;
    }
    int mid = (start + end) / 2;

    build(node * 2, start, mid);

    build(node * 2 + 1, mid + 1, end);

    tree[node].resize(tree[node * 2].size() + tree[node * 2 + 1].size());
    merge(tree[node * 2].begin(), tree[node * 2].end(),
          tree[node * 2 + 1].begin(), tree[node * 2 + 1].end(),
          tree[node].begin());
}

int countLessEqual(int node, int start, int end, int L, int R, int val)
{
    if (R < start || L > end)
    {

        return 0;
    }
    if (L <= start && end <= R)
    {

        int cnt = (int)(upper_bound(tree[node].begin(), tree[node].end(), val) - tree[node].begin());
        return cnt;
    }

    int mid = (start + end) / 2;
    return countLessEqual(node * 2, start, mid, L, R, val) + countLessEqual(node * 2 + 1, mid + 1, end, L, R, val);
}

int queryKth(int l, int r, int k)
{

    int low = -1000000000;
    int high = 1000000000;
    int ret = low;

    while (low <= high)
    {
        int mid = ((long long)low + (long long)high) / 2;

        int c = countLessEqual(1, 1, n, l, r, mid);

        if (c >= k)
        {
            ret = mid;
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return ret;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
    }

    build(1, 1, n);

    while (m--)
    {
        int i, j, k;
        cin >> i >> j >> k;
        cout << queryKth(i, j, k) << "\n";
    }

    return 0;
}