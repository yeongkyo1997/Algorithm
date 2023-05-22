#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(int node, vector<int>& cycle, vector<bool>& visited, vector<int>& choose, vector<int>& team_members) {
    cycle.push_back(node);
    visited[node] = true;
    int nxt = choose[node];

    if (visited[nxt]) {
        auto it = find(cycle.begin(), cycle.end(), nxt);
        if (it != cycle.end()) {
            team_members.insert(team_members.end(), it, cycle.end());
        }
    } else {
        dfs(nxt, cycle, visited, choose, team_members);
    }
}

int main() {
    int T; 
    cin >> T;
    
    while (T--) {
        int N;
        cin >> N;
        vector<int> choose(N + 1);
        for (int i = 1; i <= N; i++) {
            cin >> choose[i];
        }

        vector<int> team_members;
        vector<bool> visited(N + 1, false);

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                vector<int> cycle;
                dfs(i, cycle, visited, choose, team_members);
            }
        }

        cout << N - team_members.size() << endl;
    }

    return 0;
}