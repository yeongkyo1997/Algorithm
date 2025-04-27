#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M, x, y, K;
    cin >> N >> M >> x >> y >> K;

    // 지도 정보 저장
    vector<vector<int>> board(N, vector<int>(M));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
        }
    }

    // 명령 입력
    vector<int> cmds(K);
    for (int i = 0; i < K; i++) {
        cin >> cmds[i];
    }

    // 주사위 상태: 1:위, 2:북, 3:동, 4:서, 5:남, 6:아래
    int dice[7] = {0,0,0,0,0,0,0};

    // 동(1), 서(2), 북(3), 남(4) 이동 벡터
    int dx[5] = {0, 0, 0, -1, 1};
    int dy[5] = {0, 1, -1, 0, 0};

    // 명령 처리
    for (int cmd : cmds) {
        int nx = x + dx[cmd];
        int ny = y + dy[cmd];

        // 범위 벗어나면 무시
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

        // 주사위 굴리기
        int temp;
        if (cmd == 1) {
            // 동쪽으로 굴리기
            temp = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = temp;
        } else if (cmd == 2) {
            // 서쪽으로 굴리기
            temp = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
        } else if (cmd == 3) {
            // 북쪽으로 굴리기
            temp = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = temp;
        } else if (cmd == 4) {
            // 남쪽으로 굴리기
            temp = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = temp;
        }

        // 이동한 칸과 주사위 바닥면 상호 복사
        if (board[nx][ny] == 0) {
            board[nx][ny] = dice[6];
        } else {
            dice[6] = board[nx][ny];
            board[nx][ny] = 0;
        }

        // 현재 윗면 출력
        cout << dice[1] << '\n';

        // 좌표 업데이트
        x = nx;
        y = ny;
    }

    return 0;
}
