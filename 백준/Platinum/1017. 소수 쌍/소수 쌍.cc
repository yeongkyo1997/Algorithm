#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

const int MAX_N = 50;
bool sieve[2002];
vector<int> adj[MAX_N];
vector<int> odds, evens;
int matchTo[MAX_N];
bool visited[MAX_N];

void buildSieve() {
    memset(sieve, true, sizeof(sieve));
    sieve[0] = sieve[1] = false;
    for (int i = 2; i * i <= 2001; ++i) {
        if (sieve[i]) {
            for (int j = i * i; j <= 2001; j += i) {
                sieve[j] = false;
            }
        }
    }
}

bool dfs(int u) {
    if (visited[u]) return false;
    visited[u] = true;
    for (int v : adj[u]) {
        if (matchTo[v] == -1 || dfs(matchTo[v])) {
            matchTo[v] = u;
            return true;
        }
    }
    return false;
}

int bipartite(int size) {
    memset(matchTo, -1, sizeof(matchTo));
    int cnt = 0;
    for (int u = 0; u < size; ++u) {
        memset(visited, false, sizeof(visited));
        if (dfs(u)) cnt++;
    }
    return cnt;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    buildSieve();
    
    int N;
    cin >> N;
    vector<int> numbers(N);
    for (int i = 0; i < N; ++i) {
        cin >> numbers[i];
    }
    if (N == 0) {
        cout << -1;
        return 0;
    }
    int x = numbers[0];
    vector<int> candidates;
    for (int y : numbers) {
        if (y == x) continue;
        if ((x % 2) != (y % 2) && sieve[x + y]) {
            candidates.push_back(y);
        }
    }
    sort(candidates.begin(), candidates.end());
    candidates.erase(unique(candidates.begin(), candidates.end()), candidates.end());
    
    vector<int> res;
    for (int y : candidates) {
        vector<int> remaining;
        for (int num : numbers) {
            if (num == x || num == y) continue;
            remaining.push_back(num);
        }
        odds.clear();
        evens.clear();
        for (int num : remaining) {
            if (num % 2 == 1) odds.push_back(num);
            else evens.push_back(num);
        }
        if (odds.size() != evens.size()) continue;
        if (odds.empty() && evens.empty()) {
            res.push_back(y);
            continue;
        }
        for (int i = 0; i < odds.size(); ++i) {
            adj[i].clear();
            for (int j = 0; j < evens.size(); ++j) {
                if (sieve[odds[i] + evens[j]]) {
                    adj[i].push_back(j);
                }
            }
        }
        int cnt = bipartite(odds.size());
        if (cnt == odds.size()) {
            res.push_back(y);
        }
    }
    if (res.empty()) {
        cout << -1;
    } else {
        sort(res.begin(), res.end());
        for (int num : res) {
            cout << num << ' ';
        }
    }
    return 0;
}