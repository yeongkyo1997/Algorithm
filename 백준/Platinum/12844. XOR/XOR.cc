#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

const int MAX = 2000000;

unsigned int tree[2000001];
unsigned int lazy[2000001];
int N;
vector<unsigned int> A;

void build(int node, int start, int end)
{
    if (start == end)
    {
        tree[node] = A[start];
    }
    else
    {
        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }
}

void push_down(int node, int start, int end)
{
    if (lazy[node] != 0)
    {
        int mid = (start + end) / 2;
        int left = 2 * node;
        int right = 2 * node + 1;

        int left_size = mid - start + 1;
        int right_size = end - mid;

        if (left_size % 2 == 1)
        {
            tree[left] ^= lazy[node];
        }
        lazy[left] ^= lazy[node];

        if (right_size % 2 == 1)
        {
            tree[right] ^= lazy[node];
        }
        lazy[right] ^= lazy[node];

        lazy[node] = 0;
    }
}

void update(int node, int start, int end, int left, int right, unsigned int val)
{
    if (right < start || end < left)
    {

        return;
    }
    if (left <= start && end <= right)
    {
        if ((end - start + 1) % 2 == 1)
        {
            tree[node] ^= val;
        }
        lazy[node] ^= val;
        return;
    }

    push_down(node, start, end);
    int mid = (start + end) / 2;
    update(2 * node, start, mid, left, right, val);
    update(2 * node + 1, mid + 1, end, left, right, val);
    tree[node] = tree[2 * node] ^ tree[2 * node + 1];
}

unsigned int query(int node, int start, int end, int left, int right)
{
    if (right < start || end < left)
    {

        return 0;
    }
    if (left <= start && end <= right)
    {
        return tree[node];
    }

    push_down(node, start, end);
    int mid = (start + end) / 2;
    unsigned int p1 = query(2 * node, start, mid, left, right);
    unsigned int p2 = query(2 * node + 1, mid + 1, end, left, right);
    return p1 ^ p2;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    A.resize(N);

    for (int i = 0; i < N; i++)
        cin >> A[i];

    memset(lazy, 0, sizeof(lazy));

    build(1, 0, N - 1);

    int M;
    cin >> M;

    string result;
    result.reserve(M * 20);

    while (M--)
    {
        int q;
        cin >> q;
        if (q == 1)
        {
            int i, j;
            unsigned int k;
            cin >> i >> j >> k;
            update(1, 0, N - 1, i, j, k);
        }
        else if (q == 2)
        {
            int i, j;
            cin >> i >> j;
            unsigned int ret = query(1, 0, N - 1, i, j);
            result += to_string(ret) + "\n";
        }
    }

    cout << result;
}