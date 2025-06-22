#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

const int MAXN = 100005;
const int MAXM = 100005;

int n, m;
int a[MAXN];
int compressed_a[MAXN];
long long bit[MAXN];
int bit_size;

struct Query {
    int s, e, id;
};

Query queries[MAXM];
long long ans[MAXM];
int block_size;

void update(int idx, int val) {
    for (; idx <= bit_size; idx += idx & -idx) {
        bit[idx] += val;
    }
}

long long query(int idx) {
    long long sum = 0;
    for (; idx > 0; idx -= idx & -idx) {
        sum += bit[idx];
    }
    return sum;
}

bool compareQueries(const Query& q1, const Query& q2) {
    int block1 = q1.s / block_size;
    int block2 = q2.s / block_size;
    if (block1 != block2) {
        return block1 < block2;
    }
    if (block1 % 2) {
        return q1.e < q2.e;
    }
    return q1.e > q2.e;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    block_size = sqrt(n);

    vector<int> coords;
    coords.reserve(n);
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
        coords.push_back(a[i]);
    }

    sort(coords.begin(), coords.end());
    coords.erase(unique(coords.begin(), coords.end()), coords.end());

    bit_size = coords.size();
    for (int i = 1; i <= n; ++i) {
        compressed_a[i] = lower_bound(coords.begin(), coords.end(), a[i]) - coords.begin() + 1;
    }

    for (int i = 0; i < m; ++i) {
        cin >> queries[i].s >> queries[i].e;
        queries[i].id = i;
    }

    sort(queries, queries + m, compareQueries);

    int current_s = 1;
    int current_e = 0;
    long long current_ans = 0;

    for (int i = 0; i < m; ++i) {
        int s = queries[i].s;
        int e = queries[i].e;

        while (current_s > s) {
            current_s--;
            current_ans += query(compressed_a[current_s] - 1);
            update(compressed_a[current_s], 1);
        }
        while (current_e < e) {
            current_e++;
            current_ans += (query(bit_size) - query(compressed_a[current_e]));
            update(compressed_a[current_e], 1);
        }
        while (current_s < s) {
            update(compressed_a[current_s], -1);
            current_ans -= query(compressed_a[current_s] - 1);
            current_s++;
        }
        while (current_e > e) {
            update(compressed_a[current_e], -1);
            current_ans -= (query(bit_size) - query(compressed_a[current_e]));
            current_e--;
        }
        
        ans[queries[i].id] = current_ans;
    }

    for (int i = 0; i < m; ++i) {
        cout << ans[i] << "\n";
    }

    return 0;
}