#include <bits/stdc++.h>
using namespace std;

int M, N, K;
int board[101][101];
bool vis[101][101];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> M >> N >> K;
    // 직사각형 채우기
    for(int i = 0; i < K; i++){
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        for(int y = y1; y < y2; y++){
            for(int x = x1; x < x2; x++){
                board[y][x] = 1;
            }
        }
    }

    vector<int> areas;

    // BFS로 빈 칸 영역 찾기
    for(int y = 0; y < M; y++){
        for(int x = 0; x < N; x++){
            if(board[y][x] == 0 && !vis[y][x]){
                int cnt = 0;
                queue<pair<int,int>> q;
                vis[y][x] = true;
                q.push({y, x});

                while(!q.empty()){
                    auto cur = q.front(); q.pop();
                    int cy = cur.first;
                    int cx = cur.second;
                    cnt++;
                    for(int dir = 0; dir < 4; dir++){
                        int ny = cy + dy[dir];
                        int nx = cx + dx[dir];
                        if(ny<0 || ny>=M || nx<0 || nx>=N) continue;
                        if(vis[ny][nx] || board[ny][nx]==1) continue;
                        vis[ny][nx] = true;
                        q.push({ny, nx});
                    }
                }
                areas.push_back(cnt);
            }
        }
    }

    sort(areas.begin(), areas.end());
    cout << areas.size() << "\n";
    for(int a : areas) cout << a << " ";
    cout << "\n";
    return 0;
}