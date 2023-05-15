#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> digraph, rdigraph, res;
vector<bool> visited;
stack<int> stack_;

void dfs(int start) {
    visited[start] = true;

    for (int now : digraph[start]) {
        if (!visited[now]) {
            dfs(now);
        }
    }

    stack_.push(start);
}

void redfs(int start, int groupNum) {
    visited[start] = true;
    res[groupNum].push_back(start);

    for (int now : rdigraph[start]) {
        if (!visited[now]) {
            redfs(now, groupNum);
        }
    }
}

int main() {
    int V, E;
    cin >> V >> E;

    digraph.resize(V + 1);
    rdigraph.resize(V + 1);
    res.resize(V + 1);
    visited.resize(V + 1, false);

    for (int i = 0; i < E; i++) {
        int A, B;
        cin >> A >> B;

        digraph[A].push_back(B);
        rdigraph[B].push_back(A);
    }

    for (int i = 1; i <= V; i++) {
        if (!visited[i]) {
            dfs(i);
        }
    }

    fill(visited.begin(), visited.end(), false);
    int groupNum = 0;

    while (!stack_.empty()) {
        int start = stack_.top();
        stack_.pop();

        if (visited[start]) {
            continue;
        }

        redfs(start, groupNum);
        groupNum++;
    }

    cout << groupNum << "\n";

    map<int, int> orderMap;
    for (int i = 0; i < groupNum; i++) {
        sort(res[i].begin(), res[i].end());
        orderMap[res[i].front()] = i;
    }

    for (auto& it : orderMap) {
        int idx = it.second;
        for (int now : res[idx]) {
            cout << now << " ";
        }
        cout << "-1\n";
    }
    return 0;
}