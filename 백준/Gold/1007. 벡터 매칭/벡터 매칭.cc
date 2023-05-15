#include <iostream>
#include <cmath>
#include <algorithm>
#include <cstring>
using namespace std;

typedef long long ll;
typedef double d;
typedef pair<d, d> pdd;
typedef pair<int,int> pii;
int n;
int half;
pdd p[21];
int visit[21];

d cal() {
    pdd pos = { 0,0 };
    pdd neg = { 0,0 };
    for (int i = 0; i < n; i++) {
        if (visit[i]) {
            pos.first += p[i].first;
            pos.second += p[i].second;
        }
        else {
            neg.first += p[i].first;
            neg.second += p[i].second;
        }
    }
    d _dist = sqrt((pos.first - neg.first) * (pos.first - neg.first) + (pos.second - neg.second) * (pos.second - neg.second));
    return _dist;
}

d dfs(int index, int level) {
    if (level == half) {
        return cal();
    }
  
    d _min = 40000000007.0;
    for (int i = index; i < n; i++) {
        visit[i] = 1;
        _min = min(_min, dfs(i + 1, level + 1));
        visit[i] = 0;
    }
  
    return _min;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
  
    int t;
    cin >> t;
    cout << fixed;
    cout.precision(7);
    for (; t--;) {
        memset(visit, 0, sizeof(visit));
        cin >> n;
        half = n / 2;
        for (int i = 0; i < n; i++) {
            cin >> p[i].first >> p[i].second;
        }
        cout << dfs(0, 0) << "\n";
    }
}