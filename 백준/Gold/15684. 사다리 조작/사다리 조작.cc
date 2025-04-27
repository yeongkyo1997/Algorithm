#include <bits/stdc++.h>
using namespace std;

int N, M, H;
bool ladder[31+1][10+1]; // ladder[r][c]=r번째 가로줄에 c번 세로선과 c+1번 세로선 사이에 가로선이 있으면 true
int ans = 4;              // 최소 추가 개수 (최대 3까지 가능하므로 초기값 4)

/// 사다리 결과가 i→i 로 되는지 검사
bool check() {
    for (int start = 1; start <= N; start++) {
        int pos = start;
        for (int r = 1; r <= H; r++) {
            // 현재 위치에서 오른쪽으로 연결선이 있으면 우측으로 이동
            if (pos <= N-1 && ladder[r][pos]) {
                pos++;
            }
            // 왼쪽 연결선이 있으면 좌측으로 이동
            else if (pos > 1 && ladder[r][pos-1]) {
                pos--;
            }
        }
        if (pos != start) return false;
    }
    return true;
}

/// idx: flattened position index (1..H*(N-1))  
/// cnt: 지금까지 추가한 가로선 개수
void dfs(int idx, int cnt) {
    // 현재 상태로도 목표 달성 가능하면 ans 갱신 후 종료
    if (check()) {
        ans = min(ans, cnt);
        return;
    }
    // 이미 3개 추가했거나, 더 추가해도 현재 ans 이상이면 중단
    if (cnt == 3 || cnt >= ans) return;

    int total = H * (N - 1);
    for (int k = idx; k <= total; k++) {
        int r = (k - 1) / (N - 1) + 1;
        int c = (k - 1) % (N - 1) + 1;
        // 이미 선이 있거나 좌우에 인접 선이 있으면 못 놓음
        if (ladder[r][c]) continue;
        if (c > 1 && ladder[r][c-1]) continue;
        if (c < N && ladder[r][c+1]) continue;

        // 가로선 추가
        ladder[r][c] = true;
        dfs(k + 1, cnt + 1);
        ladder[r][c] = false;

        // 만약 답이 cnt+1로 갱신됐다면 더 깊이 볼 필요 없음
        if (ans <= cnt + 1) return;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M >> H;
    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        ladder[a][b] = true;
    }

    dfs(1, 0);

    // 3을 초과하면 불가능
    if (ans > 3) ans = -1;
    cout << ans << "\n";
    return 0;
}
