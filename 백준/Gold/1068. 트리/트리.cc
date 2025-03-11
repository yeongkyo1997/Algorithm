#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> parent(N);
    vector<vector<int>> children(N);
    int root;

    for (int i = 0; i < N; ++i) {
        cin >> parent[i];
        if (parent[i] == -1) {
            root = i;
        } else {
            children[parent[i]].push_back(i);
        }
    }

    int D;
    cin >> D;

    vector<bool> deleted(N, false);

    // Check if D is the root
    if (D == root) {
        cout << 0;
        return 0;
    }

    queue<int> q;
    q.push(D);
    deleted[D] = true;

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        for (int v : children[u]) {
            if (!deleted[v]) {
                deleted[v] = true;
                q.push(v);
            }
        }
    }

    int count = 0;
    for (int i = 0; i < N; ++i) {
        if (deleted[i]) continue;

        bool is_leaf = true;
        for (int child : children[i]) {
            if (!deleted[child]) {
                is_leaf = false;
                break;
            }
        }

        if (is_leaf) {
            ++count;
        }
    }

    cout << count;

    return 0;
}