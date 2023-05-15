#include <iostream>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

int order = 1;
vector<int> discover;
vector<bool> isCutVertax;

int dfs(int vertex, bool isRoot, vector<vector<int>>& adj_list) {
    discover[vertex] = order++;
    int ret = discover[vertex];
    int child = 0;

    for (int now : adj_list[vertex]) {
        if (discover[now] == 0) {
            child++;

            int low = dfs(now, false, adj_list);

            if (!isRoot && low >= discover[vertex]) {
                isCutVertax[vertex] = true;
            }
            ret = min(ret, low);
        } else {
            ret = min(ret, discover[now]);
        }
    }

    if (isRoot && child >= 2) {
        isCutVertax[vertex] = true;
    }

    return ret;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int V, E;
    cin >> V >> E;

    vector<vector<int>> adj_list(V + 1);

    for (int i = 0; i < E; i++) {
        int A, B;
        cin >> A >> B;

        adj_list[A].push_back(B);
        adj_list[B].push_back(A);
    }

    discover.resize(V + 1);
    isCutVertax.resize(V + 1);

    for (int i = 1; i <= V; i++) {
        if (discover[i] == 0) {
            dfs(i, true, adj_list);
        }
    }

    stringstream ss;
    int cnt = 0;

    for (int i = 1; i <= V; i++) {
        if (isCutVertax[i]) {
            cnt++;
        }
    }

    ss << cnt << "\n";

    for (int i = 1; i <= V; i++) {
        if (isCutVertax[i]) {
            ss << i << " ";
        }
    }

    cout << ss.str();
    return 0;
}