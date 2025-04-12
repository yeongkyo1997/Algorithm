#include <bits/stdc++.h>
using namespace std;
 
const int NMAX = 100001;
int N, M;
vector<int> adj[NMAX];
int cow[NMAX], parent[NMAX], depth[NMAX], heavy[NMAX], head[NMAX], pos[NMAX];
int curPos = 0;
 
int dfs(int u, int p) {
    parent[u] = p;
    depth[u] = (p == -1 ? 0 : depth[p] + 1);
    int size = 1, maxSize = 0;
    heavy[u] = -1;
    for (int v : adj[u]) {
        if (v == p) continue;
        int subSize = dfs(v, u);
        if (subSize > maxSize) {
            maxSize = subSize;
            heavy[u] = v;
        }
        size += subSize;
    }
    return size;
}
 
void decompose(int u, int h) {
    head[u] = h;
    pos[u] = curPos++;
    if (heavy[u] != -1) decompose(heavy[u], h);
    for (int v : adj[u]) {
        if (v == parent[u] || v == heavy[u]) continue;
        decompose(v, v);
    }
}
 
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N >> M;
    for (int i = 1; i <= N; i++) cin >> cow[i];
    for (int i = 1; i < N; i++){
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    dfs(1, -1);
    decompose(1, 1);
    vector<vector<int>> posType(N + 1);
    for (int i = 1; i <= N; i++){
        posType[cow[i]].push_back(pos[i]);
    }
    for (int t = 1; t <= N; t++){
        sort(posType[t].begin(), posType[t].end());
    }
    string ans;
    ans.resize(M);
    for (int i = 0; i < M; i++){
        int a, b, pref;
        cin >> a >> b >> pref;
        bool happy = false;
        while (head[a] != head[b]){
            if (depth[head[a]] > depth[head[b]]){
                int l = pos[head[a]], r = pos[a];
                auto it = lower_bound(posType[pref].begin(), posType[pref].end(), l);
                if (it != posType[pref].end() && *it <= r){
                    happy = true;
                    break;
                }
                a = parent[head[a]];
            } else {
                int l = pos[head[b]], r = pos[b];
                auto it = lower_bound(posType[pref].begin(), posType[pref].end(), l);
                if (it != posType[pref].end() && *it <= r){
                    happy = true;
                    break;
                }
                b = parent[head[b]];
            }
        }
        if (!happy){
            int l = min(pos[a], pos[b]), r = max(pos[a], pos[b]);
            auto it = lower_bound(posType[pref].begin(), posType[pref].end(), l);
            if (it != posType[pref].end() && *it <= r)
                happy = true;
        }
        ans[i] = (happy ? '1' : '0');
    }
    cout << ans << "\n";
    return 0;
}
