#include <iostream>
#include <vector>
#include <algorithm>  // reverse 사용 위해 추가
using namespace std;

int N, K;
int color[12][12];                // 0:흰, 1:빨, 2:파
vector<int> board[12][12];        // 칸별 말 스택 (아래→위 순서)
int dr[5] = {0, 0, 0, -1, 1};      // 1→,2←,3↑,4↓
int dc[5] = {0, 1, -1, 0, 0};
int rev_dir[5] = {0, 2, 1, 4, 3};  // 반대 방향

struct Horse {
    int r, c, d;
} horse[10];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> K;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> color[i][j];
        }
    }
    // 말 초기 위치와 방향 입력, 보드에 올리기
    for(int i = 0; i < K; i++){
        int r, c, d;
        cin >> r >> c >> d;
        r--, c--;
        horse[i] = {r, c, d};
        board[r][c].push_back(i);
    }

    int turn = 0;
    while(++turn){
        if(turn > 1000){
            cout << -1 << "\n";
            return 0;
        }
        // 1번 말부터 K번 말까지 이동
        for(int i = 0; i < K; i++){
            int r = horse[i].r;
            int c = horse[i].c;
            int d = horse[i].d;
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 파란색 또는 범위 벗어나면 방향 반대로
            if(nr<0||nr>=N||nc<0||nc>=N|| color[nr][nc]==2){
                d = rev_dir[d];
                horse[i].d = d;
                nr = r + dr[d];
                nc = c + dc[d];
                // 두 번째도 파랑이면 이동 못함
                if(nr<0||nr>=N||nc<0||nc>=N|| color[nr][nc]==2) 
                    continue;
            }

            // 현재 칸에서 i번 말 위에 쌓인 말들 떼기
            vector<int> &stk = board[r][c];
            int idx = 0;
            while(stk[idx] != i) idx++;
            vector<int> moving;
            for(int k = idx; k < (int)stk.size(); k++){
                moving.push_back(stk[k]);
            }
            stk.resize(idx);

            // 흰(0) / 빨(1)에 따라 순서 조정
            if(color[nr][nc] == 1){
                // 빨간 칸: 순서 뒤집기
                reverse(moving.begin(), moving.end());
            }
            // 말 옮기기
            for(int id : moving){
                board[nr][nc].push_back(id);
                horse[id].r = nr;
                horse[id].c = nc;
            }
            // 4개 이상 쌓이면 종료
            if((int)board[nr][nc].size() >= 4){
                cout << turn << "\n";
                return 0;
            }
        }
    }

    return 0;
}
