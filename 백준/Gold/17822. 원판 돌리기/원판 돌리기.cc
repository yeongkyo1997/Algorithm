#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M, T;
vector<vector<int>> board;  // 원판들의 숫자 배열

// 방향별 이동 오프셋 (행 변화, 열 변화)
int dr[4] = {0, 0, -1, 1};  // 0:좌, 1:우, 2:상, 3:하 (회전 이후 인접 검사용)
int dc[4] = {-1, 1, 0, 0};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M >> T;
    board.assign(N, vector<int>(M));
    // 원판 초기 상태 입력
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> board[i][j];
        }
    }

    // T번 회전 연산 수행
    for(int t = 0; t < T; t++){
        int x, d, k;
        cin >> x >> d >> k;
        k %= M;  // M만큼 돌면 원위치

        // 1) 번호가 x의 배수인 원판들 회전
        for(int i = x-1; i < N; i += x){
            auto &v = board[i];
            if(d == 0){
                // 시계 방향으로 k칸: 오른쪽으로 k만큼 시프트
                rotate(v.begin(), v.end() - k, v.end());
            } else {
                // 반시계 방향으로 k칸: 왼쪽으로 k만큼 시프트
                rotate(v.begin(), v.begin() + k, v.end());
            }
        }

        // 2) 인접하면서 같은 수 찾기
        vector<vector<bool>> remove(N, vector<bool>(M, false));
        bool any_remove = false;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int val = board[i][j];
                if(val == 0) continue;  // 빈 칸
                // 네 방향 검사
                // 좌우 (원통형 연결)
                int nj = (j - 1 + M) % M;
                if(board[i][nj] == val){
                    remove[i][j] = remove[i][nj] = true;
                }
                nj = (j + 1) % M;
                if(board[i][nj] == val){
                    remove[i][j] = remove[i][nj] = true;
                }
                // 상하 (디스크 간)
                for(int dir = 2; dir < 4; dir++){
                    int ni = i + dr[dir];
                    int nj2 = j + dc[dir];
                    if(ni < 0 || ni >= N) continue;
                    if(board[ni][nj2] == val){
                        remove[i][j] = remove[ni][nj2] = true;
                    }
                }
                if(remove[i][j]) any_remove = true;
            }
        }

        // 3) 삭제 또는 평균 조정
        if(any_remove){
            // 같은 수 지우기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(remove[i][j]) board[i][j] = 0;
                }
            }
        } else {
            // 남은 수의 합과 개수 계산
            long long sum = 0;
            int cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(board[i][j] != 0){
                        sum += board[i][j];
                        cnt++;
                    }
                }
            }
            if(cnt > 0){
                // 평균보다 큰 수는 -1, 작은 수는 +1
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < M; j++){
                        if(board[i][j] == 0) continue;
                        // board[i][j] > sum/cnt  ↔  board[i][j]*cnt > sum
                        if((long long)board[i][j] * cnt > sum) board[i][j]--;
                        else if((long long)board[i][j] * cnt < sum) board[i][j]++;
                    }
                }
            }
        }
    }

    // 최종 합 계산 및 출력
    long long answer = 0;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            answer += board[i][j];
        }
    }
    cout << answer << "\n";
    return 0;
}
