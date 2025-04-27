#include <bits/stdc++.h>
using namespace std;

// DP 상태를 나타내는 구조체
struct State {
    int count;     // 0: 불가능, 1: 유일, 2: 다중(2개 이상)
    string seq;    // count==1일 때만 유효한 비트열
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<string> rows(5);
    for (int i = 0; i < 5; i++) {
        cin >> rows[i];
    }

    // 각 열 j에 대해 white(0)/black(1) 가능 여부를 계산
    vector<array<bool,2>> can(N+1, {true,true});
    for (int j = 1; j <= N; j++) {
        for (int i = 0; i < 5; i++) {
            char ch = rows[i][j-1];
            if (ch == 'X')      can[j][0] = false;  // 검은칸이면 white 불가
            else if (ch == '.') can[j][1] = false;  // 흰칸이면 black 불가
        }
    }

    // 전역 결과 상태: 전체 시작색(s=0,1)과 마지막 색(c=0,1) 합친 "넓이 sequence"의 집합이
    // 유일하면 count==1, 아니면 count==0 또는 2.
    State global = {0, ""};

    // 시작색 s = 0(white), 1(black) 둘 다 시도
    for (int s = 0; s < 2; s++) {
        // dp[pos][c]: 1..N까지 pos열까지 모두 처리했고, 마지막 막대 색이 c인 경우의 상태
        vector<array<State,2>> dp(N+1);
        // 초기화
        for (int i = 0; i <= N; i++) {
            for (int c = 0; c < 2; c++) {
                dp[i][c].count = 0;
                dp[i][c].seq.clear();
            }
        }
        // 첫 막대 이전의 "가상 색"을 !s로 설정해 두어,
        // 첫 전이에서 실제 첫 막대 색 c1 = s 가 되도록 함
        dp[0][!s].count = 1;
        dp[0][!s].seq = "";

        // DP 전개
        for (int pos = 0; pos <= N; pos++) {
            for (int c = 0; c < 2; c++) {
                int old_cnt = dp[pos][c].count;
                if (old_cnt == 0) continue;
                bool old_unique = (old_cnt == 1);
                const string &old_seq = dp[pos][c].seq;

                // 다음 막대는 색이 !c, 폭은 1 또는 2
                for (int w = 1; w <= 2; w++) {
                    int np = pos + w;
                    if (np > N) break;
                    int nc = 1 - c;
                    // pos+1..np 열이 모두 색 nc를 허용하는지 검사
                    bool ok = true;
                    for (int j = pos+1; j <= np; j++) {
                        if (!can[j][nc]) { ok = false; break; }
                    }
                    if (!ok) continue;

                    // 새로 추가되는 상태
                    State add;
                    if (old_cnt >= 2) {
                        add.count = 2;    // 부모가 다중이면 무조건 다중
                    } else {
                        // old_cnt == 1
                        add.count = 1;
                        add.seq = old_seq + char('0' + (w==2));  
                        // w==1 -> '0', w==2 -> '1'
                    }

                    // dp[np][nc]와 병합
                    State &dst = dp[np][nc];
                    if (dst.count == 0) {
                        dst = add;
                    } else {
                        // 이미 dst에 무언가 있음 -> 합치기
                        if (dst.count >= 2 || add.count >= 2) {
                            dst.count = 2;
                            dst.seq.clear();
                        } else {
                            // 둘 다 count==1
                            if (dst.seq != add.seq) {
                                dst.count = 2;
                                dst.seq.clear();
                            }
                            // 같으면 그대로 유지
                        }
                    }
                }
            }
        }

        // pos == N에서 c=0,1 두 가지 상태를 전역 결과에 병합
        for (int c = 0; c < 2; c++) {
            State &st = dp[N][c];
            if (st.count == 0) continue;
            State add;
            if (st.count >= 2) {
                add.count = 2;
            } else {
                add.count = 1;
                add.seq = st.seq;
            }
            // global과 병합
            if (global.count == 0) {
                global = add;
            } else {
                if (global.count >= 2 || add.count >= 2) {
                    global.count = 2;
                    global.seq.clear();
                } else {
                    // 둘 다 count==1
                    if (global.seq != add.seq) {
                        global.count = 2;
                        global.seq.clear();
                    }
                }
            }
        }
    }

    // 결과 출력
    if (global.count == 1) {
        cout << global.seq << "\n";
    } else {
        cout << "UNDETERMINABLE\n";
    }
    return 0;
}
