#include <bits/stdc++.h>

using namespace std;

struct Info {
    int dist;
    int idx;

    Info(int dist, int idx) : dist(dist), idx(idx) {}

    bool operator>(const Info& other) const {
        return dist > other.dist;
    }
};

int N, K;
vector<int> dist, left_, right_;
vector<bool> isVisited;
int res;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> K;

    dist.resize(N + 2);
    right_.resize(N + 2);
    left_.resize(N + 2);
    isVisited.resize(N + 2);

    dist[1] = 1'000'000'000;
    dist[N + 1] = 1'000'000'000;

    left_[N + 1] = N;
    right_[1] = 2;

    priority_queue<Info, vector<Info>, greater<Info>> pq;
    pq.push(Info(1'000'000'000, 1));
    pq.push(Info(1'000'000'000, N + 1));

    int s1;
    cin >> s1;
    for (int i = 2; i <= N; i++) {
        int s2;
        cin >> s2;
        dist[i] = s2 - s1;
        pq.push(Info(dist[i], i));
        left_[i] = i - 1;
        right_[i] = i + 1;
        s1 = s2;
    }

    res = 0;
    while (K-- > 0) {
        while (isVisited[pq.top().idx]) {
            pq.pop();
        }
        Info cur = pq.top();
        pq.pop();
        int d = cur.dist;
        int idx = cur.idx;
        res += d;
        dist[idx] = dist[left_[idx]] + dist[right_[idx]] - dist[idx];
        pq.push(Info(dist[idx], idx));
        isVisited[left_[idx]] = true;
        isVisited[right_[idx]] = true;
        left_[idx] = left_[left_[idx]];
        right_[idx] = right_[right_[idx]];
        right_[left_[idx]] = idx;
        left_[right_[idx]] = idx;
    }

    cout << res << endl;

    return 0;
}
