#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;

const int MAXN = 100005;
const int MAX_VAL = 2000005;

int n, k;
int p[MAXN];
int block_size;
long long current_ans;
long long ans[MAXN];
int freq[MAX_VAL];

struct Query {
    int l, r, id;
};

Query queries[MAXN];

bool compareQueries(const Query& q1, const Query& q2) {
    int block1 = (q1.l - 1) / block_size;
    int block2 = (q2.l - 1) / block_size;
    if (block1 != block2) {
        return block1 < block2;
    }
    if (block1 % 2) {
        return q1.r < q2.r;
    }
    return q1.r > q2.r;
}

void add(int idx) {
    current_ans += freq[p[idx] ^ k];
    freq[p[idx]]++;
}

void remove(int idx) {
    freq[p[idx]]--;
    current_ans -= freq[p[idx] ^ k];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> k;

    p[0] = 0;
    for (int i = 1; i <= n; ++i) {
        int val;
        cin >> val;
        p[i] = p[i - 1] ^ val;
    }

    int m;
    cin >> m;
    for (int i = 0; i < m; ++i) {
        cin >> queries[i].l >> queries[i].r;
        queries[i].id = i;
    }

    block_size = sqrt(n);
    sort(queries, queries + m, compareQueries);

    int current_l = 0;
    int current_r = -1;
    current_ans = 0;

    for (int i = 0; i < m; ++i) {
        int l = queries[i].l - 1;
        int r = queries[i].r;

        while (current_l > l) {
            current_l--;
            add(current_l);
        }
        while (current_r < r) {
            current_r++;
            add(current_r);
        }
        while (current_l < l) {
            remove(current_l);
            current_l++;
        }
        while (current_r > r) {
            remove(current_r);
            current_r--;
        }
        
        ans[queries[i].id] = current_ans;
    }

    for (int i = 0; i < m; ++i) {
        cout << ans[i] << "\n";
    }

    return 0;
}