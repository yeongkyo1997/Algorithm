#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M, K;
    cin >> N >> M >> K;
    vector<vector<int>> A(N, vector<int>(M));
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> A[i][j];
        }
    }

    // 1) 같은 값으로 연결된 칸 크기 미리 구해두기
    vector<vector<int>> comp(N, vector<int>(M, 0));
    vector<vector<bool>> vis(N, vector<bool>(M, false));
    int dr4[4] = {1,-1,0,0}, dc4[4] = {0,0,1,-1};
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(!vis[i][j]){
                int v = A[i][j];
                queue<pair<int,int>> q;
                vector<pair<int,int>> cells;
                vis[i][j] = true;
                q.push(make_pair(i,j));
                cells.push_back(make_pair(i,j));
                while(!q.empty()){
                    pair<int,int> p = q.front(); q.pop();
                    int r = p.first, c = p.second;
                    for(int d = 0; d < 4; d++){
                        int nr = r + dr4[d], nc = c + dc4[d];
                        if(nr>=0 && nr<N && nc>=0 && nc<M && !vis[nr][nc] && A[nr][nc]==v){
                            vis[nr][nc] = true;
                            q.push(make_pair(nr,nc));
                            cells.push_back(make_pair(nr,nc));
                        }
                    }
                }
                int sz = (int)cells.size();
                for(size_t k = 0; k < cells.size(); k++){
                    comp[cells[k].first][cells[k].second] = sz;
                }
            }
        }
    }

    // 다이스 상태: 0=top,1=bottom,2=left,3=right,4=front(south),5=back(north)
    int dice[6] = {1,6,4,3,5,2};

    // 초기 위치와 방향
    int r = 0, c = 0;
    int dir = 0; // 0=east,1=south,2=west,3=north
    int dr[4] = {0,1,0,-1}, dc[4] = {1,0,-1,0};

    long long score = 0;

    for(int step = 0; step < K; step++){
        int nr = r + dr[dir], nc = c + dc[dir];
        if(nr<0 || nr>=N || nc<0 || nc>=M){
            // 경계면 반대로
            dir = (dir + 2) % 4;
            nr = r + dr[dir];
            nc = c + dc[dir];
        }
        // 굴리기
        int top=dice[0], bot=dice[1], left=dice[2], right=dice[3], front=dice[4], back=dice[5];
        if(dir == 0){         // east
            dice[0] = left;  dice[1] = right;
            dice[2] = bot;   dice[3] = top;
            dice[4] = front; dice[5] = back;
        } else if(dir == 2){  // west
            dice[0] = right; dice[1] = left;
            dice[2] = top;   dice[3] = bot;
            dice[4] = front; dice[5] = back;
        } else if(dir == 1){  // south
            dice[0] = back;  dice[1] = front;
            dice[4] = top;   dice[5] = bot;
            dice[2] = left;  dice[3] = right;
        } else {              // north
            dice[0] = front; dice[1] = back;
            dice[4] = bot;   dice[5] = top;
            dice[2] = left;  dice[3] = right;
        }
        r = nr; c = nc;

        int B = A[r][c];
        int C = comp[r][c];
        score += 1LL * B * C;

        int A_bot = dice[1];
        if(A_bot > B)      dir = (dir + 1) % 4;      // 시계 회전
        else if(A_bot < B) dir = (dir + 3) % 4;      // 반시계 회전
        // 같으면 방향 유지
    }

    cout << score << "\n";
    return 0;
}
