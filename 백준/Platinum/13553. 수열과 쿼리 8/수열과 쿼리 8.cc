#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

const int MAX_A_VAL = 100000;
const int BIT_SIZE = MAX_A_VAL + 1;

int N, K, M;
vector<int> A;
vector<long long> bit;
long long current_ans = 0;
int sqrtN;

struct Query {
    int l, r, index;
    bool operator<(const Query& other) const {
        int block_l = l / sqrtN;
        int block_other = other.l / sqrtN;
        if (block_l != block_other) {
            return block_l < block_other;
        }
        if (block_l % 2) {
            return r > other.r;
        } else {
            return r < other.r;
        }
    }
};

void update(int idx, int delta) {
    for (; idx < BIT_SIZE; idx += idx & -idx) {
        bit[idx] += delta;
    }
}

long long query(int idx) {
    long long sum = 0;
    idx = min(idx, BIT_SIZE - 1);
    for (; idx > 0; idx -= idx & -idx) {
        sum += bit[idx];
    }
    return sum;
}

void add(int index) {
    int val = A[index];
    int lower_bound = max(1, val - K);
    int upper_bound = min(MAX_A_VAL, val + K);
    if (lower_bound <= upper_bound) {
        current_ans += query(upper_bound) - query(lower_bound - 1);
    }
    update(val, 1);
}

void remove(int index) {
    int val = A[index];
    update(val, -1);
    int lower_bound = max(1, val - K);
    int upper_bound = min(MAX_A_VAL, val + K);
    if (lower_bound <= upper_bound) {
        current_ans -= query(upper_bound) - query(lower_bound - 1);
    }
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> K;

    A.resize(N + 1);
    bit.resize(BIT_SIZE, 0);

    for (int i = 1; i <= N; ++i) {
        cin >> A[i];
    }

    cin >> M;
    vector<Query> queries(M);

    for (int i = 0; i < M; ++i) {
        cin >> queries[i].l >> queries[i].r;
        queries[i].index = i;
    }

    sqrtN = sqrt(N);
    if (sqrtN == 0) sqrtN = 1;


    sort(queries.begin(), queries.end());

    vector<long long> ans(M);

    int current_l = 1;
    int current_r = 0;

    for (int i = 0; i < M; ++i) {
        int l = queries[i].l;
        int r = queries[i].r;
        int index = queries[i].index;

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

        ans[index] = current_ans;
    }

    for (int i = 0; i < M; ++i) {
        cout << ans[i] << "\n";
    }

    return 0;
}