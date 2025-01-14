#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<int>> maps) {
    int n = maps.size();
    int m = maps[0].size();

    vector<vector<int>> dist(n, vector<int>(m, -1));
    dist[0][0] = 1;

    queue<pair<int,int>> q;
    q.push({0, 0});

    int dr[4] = {1, -1, 0, 0};
    int dc[4] = {0, 0, 1, -1};

    while(!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        if(r == n-1 && c == m-1) {
            return dist[r][c];
        }

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if(maps[nr][nc] == 0) continue;
            if(dist[nr][nc] != -1) continue;

            dist[nr][nc] = dist[r][c] + 1;
            q.push({nr, nc});
        }
    }

    return -1;
}
