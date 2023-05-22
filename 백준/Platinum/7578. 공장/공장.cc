#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<long long> tree;

long long sum(int start, int end, int node, int left, int right) {
    if (end < left || right < start) {
        return 0;
    }

    if (left <= start && end <= right) {
        return tree[node];
    }

    int mid = (start + end) / 2;
    return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
}

void update(int start, int end, int node, int idx, int diff) {
    if (idx < start || idx > end) {
        return;
    }

    tree[node] += diff;

    if (start != end) {
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, diff);
        update(mid + 1, end, node * 2 + 1, idx, diff);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> A(N + 1);

    for (int i = 1; i <= N; i++) {
        cin >> A[i];
    }

    unordered_map<int, int> B;

    for (int i = 1; i <= N; i++) {
        int val;
        cin >> val;
        B[val] = i;
    }

    tree.resize(N * 4);
    long long ans = 0;

    for (int i = 1; i <= N; i++) {
        int valA = A[i];
        int valB = B[valA];

        ans += sum(1, N, 1, valB + 1, N);
        update(1, N, 1, valB, 1);
    }

    cout << ans << '\n';
    return 0;
}