#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

struct Jewelry {
    int mass;
    int value;

    Jewelry() {}

    Jewelry(int m, int v) {
        mass = m;
        value = v;
    }

    bool operator<(const Jewelry& other) const {
        if (mass == other.mass)
            return value < other.value;
        return mass < other.mass;
    }
};


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, K;
    cin >> N >> K;

    vector<Jewelry> jewelries(N);
    for (int i = 0; i < N; i++) {
        int m, v;
        cin >> m >> v;
        jewelries[i] = Jewelry(m, v);
    }

    sort(jewelries.begin(), jewelries.end());

    vector<int> bags(K);
    for (int i = 0; i < K; i++) {
        cin >> bags[i];
    }
    sort(bags.begin(), bags.end());

    priority_queue<int> pq;
    long long ans = 0;
    for (int i = 0, j = 0; i < K; i++) {
        while (j < N && jewelries[j].mass <= bags[i]) {
            pq.push(jewelries[j++].value);
        }

        if (!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
    }

    cout << ans << "\n";

    return 0;
}