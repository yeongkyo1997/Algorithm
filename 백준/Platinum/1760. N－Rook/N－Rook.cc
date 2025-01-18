#include <bits/stdc++.h>
using namespace std;

// 전역 변수(문제 크기가 크지 않으므로 전역으로 사용해도 무방)
static const int MAXN = 100;  // N, M 최대값

int N, M;
int board[MAXN][MAXN];       // 입력 격자: 0(빈 칸), 1(구덩이), 2(벽)
int rowSegID[MAXN][MAXN];    // 각 칸이 어떤 "행 구간"에 속하는지 저장
int colSegID[MAXN][MAXN];    // 각 칸이 어떤 "열 구간"에 속하는지 저장

// 이분 매칭에 사용할 그래프
//  - left: 행 구간(노드), right: 열 구간(노드)
vector<int> adj[10000];      // 충분히 크게(최대 구간 수) 잡는다.

// 각 열 구간(col segment)이 어느 행 구간(row segment)과 매칭되었는지 저장
//  - matchCol[c] = 매칭된 행 구간 번호 (매칭 안 되어 있으면 -1)
int matchCol[10000];

// 방문 체크용
bool visited[10000];

// DFS로 증가 경로(augmenting path) 찾기
bool dfs(int rSeg) {
    // 행 구간 rSeg에서 갈 수 있는 열 구간들을 순회
    for(int cSeg: adj[rSeg]) {
        // 이미 이 탐색에서 방문한 열 구간이면 패스
        if(visited[cSeg]) continue;
        visited[cSeg] = true;

        // 아직 매칭 안 되었거나, 매칭되어 있는 행 구간을 다른 곳으로 옮길 수 있으면 매칭
        if(matchCol[cSeg] < 0 || dfs(matchCol[cSeg])) {
            matchCol[cSeg] = rSeg;
            return true;
        }
    }
    return false;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> board[i][j];
        }
    }

    // Step 1. 행 구간(row segment) 만들기
    // rowSegmentCount: 전체 행 구간의 개수
    int rowSegmentCount = 0;
    memset(rowSegID, -1, sizeof(rowSegID)); // 초기에 -1로

    for(int i = 0; i < N; i++){
        // 한 행을 왼->오른쪽으로 보며 벽을 만나면 구간을 끊는다.
        // rowSegmentCount를 행 처음에 새로 시작할 수도 있고,
        // 편의상 '현재 구간' id를 하나 두고 진행해도 된다.
        int currentSeg = rowSegmentCount;
        for(int j = 0; j < M; j++){
            if(board[i][j] == 2) {
                // 벽을 만나면 구간을 끊고 다음 번호로 넘어간다.
                currentSeg++;
            } else {
                // 벽이 아니면 현재 구간 번호 할당
                rowSegID[i][j] = currentSeg;
            }
        }
        // 이 행을 다 돌았으면, 다음 행으로 넘어가기 전에 구간 번호를 1 증가
        // (다음 행은 다른 구간으로 취급해야 하므로)
        rowSegmentCount = currentSeg + 1;
    }

    // Step 2. 열 구간(col segment) 만들기
    // colSegmentCount: 전체 열 구간의 개수
    int colSegmentCount = 0;
    memset(colSegID, -1, sizeof(colSegID));

    for(int j = 0; j < M; j++){
        int currentSeg = colSegmentCount;
        for(int i = 0; i < N; i++){
            if(board[i][j] == 2){
                // 벽이면 구간 끊고 다음 번호
                currentSeg++;
            } else {
                // 벽이 아니면 현재 구간 번호 할당
                colSegID[i][j] = currentSeg;
            }
        }
        colSegmentCount = currentSeg + 1;
    }

    // Step 3. 이분 매칭 그래프 구성
    //  - rowSegID[i][j]와 colSegID[i][j]를 이어준다 (단, 빈 칸(0)만)
    for(int i = 0; i < rowSegmentCount; i++){
        adj[i].clear(); // 혹시 모를 초기화
    }

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            // 빈 칸(0)인 경우에만 Rook 배치 가능
            if(board[i][j] == 0){
                int r = rowSegID[i][j];
                int c = colSegID[i][j];
                // r, c가 유효하면 간선 추가
                if(r >= 0 && c >= 0){
                    adj[r].push_back(c);
                }
            }
        }
    }

    // Step 4. 이분 매칭 실행 (O(V * E) 방식)
    //  - matchCol[c] = 매칭된 행 구간, 초기엔 -1
    memset(matchCol, -1, sizeof(matchCol));
    int answer = 0;

    // 모든 행 구간(r)을 순회하며 매칭 시도
    for(int r = 0; r < rowSegmentCount; r++){
        // 매 번 visited 배열을 초기화
        memset(visited, false, sizeof(visited));
        if(dfs(r)) answer++;
    }

    cout << answer << "\n";
    return 0;
}