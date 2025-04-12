#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int K = 20;

const int ALL_ONES = (1 << K) - 1;

struct Node
{
    int val_or = 0;
    int val_and = ALL_ONES;
    int max_val = 0;
    int lazy_or = 0;
    int lazy_and = ALL_ONES;
};

vector<Node> tree;
vector<int> a;
int n;

void pull(int v)
{

    if (2 * v + 1 >= tree.size())
        return;
    tree[v].val_or = tree[2 * v].val_or | tree[2 * v + 1].val_or;
    tree[v].val_and = tree[2 * v].val_and & tree[2 * v + 1].val_and;
    tree[v].max_val = max(tree[2 * v].max_val, tree[2 * v + 1].max_val);
}

void apply_transformation(int v, int op_and, int op_or)
{

    if (op_and == ALL_ONES && op_or == 0)
        return;

    tree[v].max_val = (tree[v].max_val & op_and) | op_or;
    tree[v].val_or = (tree[v].val_or & op_and) | op_or;
    tree[v].val_and = (tree[v].val_and & op_and) | op_or;

    tree[v].lazy_or = (tree[v].lazy_or & op_and) | op_or;
    tree[v].lazy_and = (tree[v].lazy_and & op_and) | op_or;
}

void push(int v)
{

    if (tree[v].lazy_and == ALL_ONES && tree[v].lazy_or == 0)
        return;

    if (2 * v + 1 >= tree.size())
        return;

    apply_transformation(2 * v, tree[v].lazy_and, tree[v].lazy_or);
    apply_transformation(2 * v + 1, tree[v].lazy_and, tree[v].lazy_or);

    tree[v].lazy_and = ALL_ONES;
    tree[v].lazy_or = 0;
}

void build(int v, int tl, int tr)
{

    tree[v].lazy_or = 0;
    tree[v].lazy_and = ALL_ONES;
    if (tl == tr)
    {

        if (tl < n)
        {
            tree[v].val_or = a[tl];
            tree[v].val_and = a[tl];
            tree[v].max_val = a[tl];
        }
        else
        {

            tree[v].val_or = 0;
            tree[v].val_and = ALL_ONES;
            tree[v].max_val = 0;
        }
    }
    else
    {
        int tm = tl + (tr - tl) / 2;
        build(2 * v, tl, tm);
        build(2 * v + 1, tm + 1, tr);
        pull(v);
    }
}

void update_and(int v, int tl, int tr, int l, int r, int x)
{

    if (r < tl || tr < l || l > r)
    {
        return;
    }

    if (l <= tl && tr <= r && ((tree[v].val_or & ~x) == (tree[v].val_and & ~x)))
    {

        apply_transformation(v, x, 0);
        return;
    }

    push(v);

    int tm = tl + (tr - tl) / 2;
    update_and(2 * v, tl, tm, l, r, x);
    update_and(2 * v + 1, tm + 1, tr, l, r, x);

    pull(v);
}

void update_or(int v, int tl, int tr, int l, int r, int x)
{

    if (r < tl || tr < l || l > r)
    {
        return;
    }

    if (l <= tl && tr <= r && ((tree[v].val_or & x) == (tree[v].val_and & x)))
    {

        apply_transformation(v, ALL_ONES, x);
        return;
    }

    push(v);

    int tm = tl + (tr - tl) / 2;
    update_or(2 * v, tl, tm, l, r, x);
    update_or(2 * v + 1, tm + 1, tr, l, r, x);

    pull(v);
}

int query_max(int v, int tl, int tr, int l, int r)
{

    if (r < tl || tr < l || l > r)
    {
        return 0;
    }

    if (l <= tl && tr <= r)
    {
        return tree[v].max_val;
    }

    push(v);

    int tm = tl + (tr - tl) / 2;
    int max_left = query_max(2 * v, tl, tm, l, r);
    int max_right = query_max(2 * v + 1, tm + 1, tr, l, r);

    return max(max_left, max_right);
}

int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    a.resize(n);

    for (int i = 0; i < n; ++i)
    {
        cin >> a[i];
    }

    tree.resize(4 * n);

    build(1, 0, n - 1);

    int m;
    cin >> m;
    for (int k = 0; k < m; ++k)
    {
        int type, l, r;
        cin >> type >> l >> r;
        l--;
        r--;

        if (type == 1)
        {
            int x;
            cin >> x;
            update_and(1, 0, n - 1, l, r, x);
        }
        else if (type == 2)
        {
            int x;
            cin >> x;
            update_or(1, 0, n - 1, l, r, x);
        }
        else
        {
            cout << query_max(1, 0, n - 1, l, r) << "\n";
        }
    }

    return 0;
}