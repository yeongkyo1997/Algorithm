#include <bits/stdc++.h>

using namespace std;

int T, c, d, v;
vector<string> v1, v2;
vector<bool> isVisited;
vector<vector<int>> edge;
vector<int> node;

bool bMatching(int now) {
    for (int next : edge[now]) {
        if (isVisited[next]) continue;
        isVisited[next] = true;
        if (node[next] == -1 || bMatching(node[next])) {
            node[next] = now;
            return true;
        }
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> T;
    while (T-- > 0) {
        cin >> c >> d >> v;

        v1.resize(v + 1);
        v2.resize(v + 1);
        node.resize(v + 1);
        edge.resize(v + 1);

        for (int i = 0; i < v; i++) edge[i] = vector<int>();

        for (int i = 0; i < v; i++) {
          cin >> v1[i] >> v2[i];
        }

        for (int i = 0; i < v - 1; i++) {
            for (int j = i + 1; j < v; j++) {
                if (v1[i] == v2[j] || v1[j] == v2[i]) {
                    if (v1[i][0] == 'C') edge[i].push_back(j);
                    else edge[j].push_back(i);
                }
            }
        }

        fill(node.begin(), node.end(), -1);
        int cnt = 0;
        for (int i = 0; i < v; i++) {
            isVisited = vector<bool>(v + 1, false);
            if (bMatching(i)) {
                cnt++;
            }
        }
        cout << v - cnt << '\n';
    }

    return 0;
}