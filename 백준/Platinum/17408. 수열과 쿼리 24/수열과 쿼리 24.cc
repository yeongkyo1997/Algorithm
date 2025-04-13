#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

struct Node {
    ll max1 = 0;
    ll max2 = 0;
};

vector<ll> a;
vector<Node> tree;

Node combine(Node left, Node right) {
    vector<ll> vals;
    if (left.max1 > 0) vals.push_back(left.max1);
    if (left.max2 > 0) vals.push_back(left.max2);
    if (right.max1 > 0) vals.push_back(right.max1);
    if (right.max2 > 0) vals.push_back(right.max2);

    sort(vals.rbegin(), vals.rend());

    Node result;
    if (vals.size() >= 1) {
        result.max1 = vals[0];
    }
    if (vals.size() >= 2) {
        result.max2 = vals[1];
    }
    return result;
}

void build(int node, int start, int end) {
    if (start == end) {
        if (start < a.size()) {
             tree[node] = {a[start], 0};
        } else {
             tree[node] = {0, 0};
        }
    } else {
        int mid = start + (end - start) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        tree[node] = combine(tree[node * 2], tree[node * 2 + 1]);
    }
}

void update(int node, int start, int end, int idx, ll val) {
    if (start == end) {
        a[idx] = val;
        tree[node] = {val, 0};
    } else {
        int mid = start + (end - start) / 2;
        if (start <= idx && idx <= mid) {
            update(node * 2, start, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, val);
        }
        tree[node] = combine(tree[node * 2], tree[node * 2 + 1]);
    }
}

Node query(int node, int start, int end, int l, int r) {
    if (r < start || end < l) {
        return {0, 0};
    }
    if (l <= start && end <= r) {
        return tree[node];
    }
    int mid = start + (end - start) / 2;
    Node p1 = query(node * 2, start, mid, l, r);
    Node p2 = query(node * 2 + 1, mid + 1, end, l, r);
    return combine(p1, p2);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    a.resize(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    int tree_size = 1;
    while(tree_size < n) tree_size *= 2;
    tree.resize(tree_size * 2);

    build(1, 0, n - 1);

    int m;
    cin >> m;

    for (int k = 0; k < m; ++k) {
        int type;
        cin >> type;
        if (type == 1) {
            int i;
            ll v;
            cin >> i >> v;
            update(1, 0, n - 1, i - 1, v);
        } else {
            int l, r;
            cin >> l >> r;
            Node result = query(1, 0, n - 1, l - 1, r - 1);
            cout << result.max1 + result.max2 << "\n";
        }
    }

    return 0;
}