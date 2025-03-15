#include <bits/stdc++.h>
using namespace std;

class FenwickTree {
private:
    vector<long long> tree;
public:
    FenwickTree(int size) : tree(size + 2, 0) {}
    
    void update(int idx, long long diff) {
        idx++;
        while (idx < tree.size()) {
            tree[idx] += diff;
            idx += (idx & -idx);
        }
    }
    
    long long query(int idx) {
        idx++;
        long long sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, M, K;
    cin >> N >> M >> K;
    
    FenwickTree bit1(N), bit2(N);
    
    for (int i = 1; i <= N; ++i) {
        long long num;
        cin >> num;
        bit1.update(i, num);
        bit1.update(i + 1, -num);
        bit2.update(i, num * (i - 1));
        bit2.update(i + 1, -num * i);
    }
    
    for (int i = 0; i < M + K; ++i) {
        int op;
        cin >> op;
        if (op == 1) {
            int b, c;
            long long d;
            cin >> b >> c >> d;
            bit1.update(b, d);
            bit1.update(c + 1, -d);
            bit2.update(b, d * (b - 1));
            bit2.update(c + 1, -d * c);
        } else {
            int b, c;
            cin >> b >> c;
            long long sum_c = bit1.query(c) * c - bit2.query(c);
            long long sum_b = bit1.query(b - 1) * (b - 1) - bit2.query(b - 1);
            cout << sum_c - sum_b << '\n';
        }
    }
    
    return 0;
}