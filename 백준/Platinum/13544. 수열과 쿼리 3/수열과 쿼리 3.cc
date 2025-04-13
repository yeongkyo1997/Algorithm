#include <iostream>
#include <vector>
#include <algorithm>

std::vector<int> tree[400005];
int arr[100005];
int n, m;

void build(int node, int start, int end) {
    if (start == end) {
        tree[node].push_back(arr[start]);
        return;
    }
    int mid = start + (end - start) / 2;
    build(node * 2, start, mid);
    build(node * 2 + 1, mid + 1, end);

    tree[node].resize(tree[node * 2].size() + tree[node * 2 + 1].size());
    std::merge(tree[node * 2].begin(), tree[node * 2].end(),
               tree[node * 2 + 1].begin(), tree[node * 2 + 1].end(),
               tree[node].begin());
}

int query(int node, int start, int end, int left, int right, int k) {
    if (right < start || end < left) {
        return 0;
    }
    if (left <= start && end <= right) {
        auto it = std::upper_bound(tree[node].begin(), tree[node].end(), k);
        return tree[node].end() - it;
    }
    int mid = start + (end - start) / 2;
    int l_count = query(node * 2, start, mid, left, right, k);
    int r_count = query(node * 2 + 1, mid + 1, end, left, right, k);
    return l_count + r_count;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    std::cin >> n;
    for (int i = 1; i <= n; ++i) {
        std::cin >> arr[i];
    }

    build(1, 1, n);

    std::cin >> m;
    int last_ans = 0;
    for (int q = 0; q < m; ++q) {
        int a, b, c;
        std::cin >> a >> b >> c;
        int i = a ^ last_ans;
        int j = b ^ last_ans;
        int k = c ^ last_ans;


        last_ans = query(1, 1, n, i, j, k);
        std::cout << last_ans << "\n";
    }

    return 0;
}