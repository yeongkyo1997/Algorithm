#include <iostream>
#include <vector>
#include <cmath>
#include <sstream>

using namespace std;

struct Node {
    int to;
    int w;

    Node(int to, int w) : to(to), w(w) {}
};

int n, h;
vector<vector<Node>> list;
vector<vector<int>> dp;
vector<int> dis;
vector<int> depth;
stringstream ss;

int getTreeH();
void init(int cur, int h, int pa);
void fillParents();
int LCA(int a, int b);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;

    list.resize(n + 1);

    int from, to, w;
    for (int i = 0; i < n - 1; i++) {
        cin >> from >> to >> w;

        list[from].emplace_back(to, w);
        list[to].emplace_back(from, w);
    }

    h = getTreeH();
    depth.resize(n + 1);
    dis.resize(n + 1);
    dp.resize(n + 1, vector<int>(h, 0));

    init(1, 1, 0);
    fillParents();

    int m, a, b;
    cin >> m;
    for (int i = 0; i < m; i++) {
        cin >> a >> b;

        int res = LCA(a, b);
        ss << dis[a] + dis[b] - 2 * dis[res]  << "\n";
    }

    cout << ss.str();
    return 0;
}

int getTreeH() {
    return static_cast<int>(ceil(log(n) / log(2)) + 1);
}

void init(int cur, int h, int pa) {
    depth[cur] = h;
    for (const Node &nxt : list[cur]) {
        if (nxt.to != pa) {
            dis[nxt.to] = dis[cur] + nxt.w;
            init(nxt.to, h + 1, cur);
            dp[nxt.to][0] = cur;
        }
    }
}

void fillParents() {
    for (int i = 1; i < h; i++) {
        for (int j = 1; j < n + 1; j++) {
            dp[j][i] = dp[dp[j][i - 1]][i - 1];
        }
    }
}

int LCA(int a, int b) {
    int ah = depth[a];
    int bh = depth[b];

    if (ah < bh) {
        swap(a, b);
    }

    for (int i = h - 1; i >= 0; i--) {
        if (pow(2, i) <= depth[a] - depth[b]) {
            a = dp[a][i];
        }
    }

    if (a == b) return a;

    for (int i = h - 1; i >= 0; i--) {
        if (dp[a][i] != dp[b][i]) {
            a = dp[a][i];
            b = dp[b][i];
        }
    }
    return dp[a][0];
}