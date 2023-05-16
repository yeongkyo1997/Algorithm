#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

vector<int> arr;
vector<vector<int>> tree;

int N, Q;

int upperbound(vector<int> &list, int val) {
    int start = 0;
    int end = list.size();
    while (start < end) {
        int mid = (start + end) / 2;
        if (list[mid] <= val) {
            start = mid + 1;
        } else {
            end = mid;
        }
    }
    return end;
}

void init(int node, int start, int end) {
    if (start == end) {
        tree[node].push_back(arr[start]);
        return;
    } else {
        init(node * 2, start, (start + end) / 2);
        init(node * 2 + 1, (start + end) / 2 + 1, end);

        tree[node] = vector<int>(tree[node * 2].size() + tree[node * 2 + 1].size());
        merge(tree[node * 2].begin(), tree[node * 2].end(), tree[node * 2 + 1].begin(), tree[node * 2 + 1].end(), tree[node].begin());
        return;
    }
}

int query(int node, int start, int end, int left, int right, int val) {
    if (end < left || start > right) {
        return 0;
    }
    if (left <= start && end <= right) {
        return tree[node].size() - upperbound(tree[node], val);
    }
    return query(node * 2, start, (start + end) / 2, left, right, val) +
           query(node * 2 + 1, (start + end) / 2 + 1, end, left, right, val);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    arr.resize(N);

    for (int i = 0; i < N; ++i)
        cin >> arr[i];

    tree.resize(N * 4);
    init(1, 0, N - 1);

    int last_ans = 0;
    cin >> Q;
    while (Q--) {
        int a, b, c;
        cin >> a >> b >> c;

        int i = (a ^ last_ans) - 1;
        int j = (b ^ last_ans) - 1;
        int k = (c ^ last_ans);
        last_ans = query(1, 0, N - 1, i, j, k);
        cout << last_ans << "\n";
    }

    return 0;
}