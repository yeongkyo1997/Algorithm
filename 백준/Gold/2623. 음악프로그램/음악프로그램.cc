#include <bits/stdc++.h>

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    vector<vector<int>> list(N + 1);
    vector<int> inCnt(N + 1, 0);

    for(int m = 0; m < M; m++) {
        int num, before, after;
        cin >> num >> before;
        
        for(int i = 1; i < num; i++) {
            cin >> after;
            inCnt[after]++;
            list[before].push_back(after);
            before = after;
        }
    }

    queue<int> q;

    for(int i = 1; i <= N; i++) {
        if(inCnt[i] == 0) {
            q.push(i);
        }
    }

    int count = 0;
    ostringstream oss;

    while(!q.empty()) {
        int cur = q.front();
        q.pop();
        count++;
        oss << cur << "\n";

        for(auto &i : list[cur]) {
            inCnt[i]--;
            if(inCnt[i] == 0) {
                q.push(i);
            }
        }
    }
    
    if(count == N) {
        cout << oss.str();
    }
    else {
        cout << 0;
    }

    return 0;
}