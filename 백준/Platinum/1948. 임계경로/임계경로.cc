#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;
int n, m,d[10010],ind[10010],rind[10010],s,e,ans;
bool check[10010];
vector<vector<pair<int, int>>> Graph,rGraph;
 
int DIST(int x, int y) {
    queue <int> q;
    q.push(x);
    while (!q.empty()) {
        int here = q.front();
        q.pop();
        for (int i = 0; i < Graph[here].size(); i++) {
            int next = Graph[here][i].first;
            int ncost = Graph[here][i].second;
            d[next] = max(d[next], d[here] + ncost);
            ind[next]--;
            if (ind[next] == 0) q.push(next);
        }
    }
    return d[y];
}
 
void CNT(int x, int y) {
    queue<int> q;
    q.push(x);
    check[x] = true;
    while (!q.empty()) {
        int here = q.front();
        q.pop();
        for (int i = 0; i < rGraph[here].size(); i++) {
            int next = rGraph[here][i].first;
            int ncost = rGraph[here][i].second;
            if (check[here] && (d[here] - d[next] == ncost)) {
                check[next] = true;
                ans += 1;
            }
            rind[next]--;
            if (rind[next] == 0) q.push(next);
        }
    }
}
 
int main() {
    scanf(" %d %d", &n, &m);
    Graph.resize(n);
    rGraph.resize(n);
    for (int i = 0; i < m; i++) {
        int x, y, z; scanf(" %d %d %d", &x, &y, &z);
        x--; y--;
        Graph[x].push_back({ y,z });
        ind[y]++;
        rGraph[y].push_back({ x,z });
        rind[x]++;
    }
    scanf(" %d %d", &s, &e);
    s--; e--;
    int dist = DIST(s, e);
    CNT(e, s);
    printf("%d\n", dist);
    printf("%d\n", ans);
    return 0;
}