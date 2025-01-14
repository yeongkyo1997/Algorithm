#include <bits/stdc++.h>
using namespace std;

// 완전 제곱수 판별 함수
bool isPerfectSquare(long long x) {
    if (x < 0) return false;
    long long r = (long long)floor(sqrt((long double)x));
    return (r * r == x);
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    // 표 입력 받기 (각 행을 문자열로 저장)
    vector<string> board(N);
    for(int i = 0; i < N; i++){
        cin >> board[i];
    }

    long long answer = -1; // 만들 수 있는 가장 큰 완전 제곱수, 초기값 -1

    // 모든 시작 위치 (r, c)
    for(int r = 0; r < N; r++){
        for(int c = 0; c < M; c++){
            // 모든 (dr, dc) 공차에 대해
            for(int dr = -N + 1; dr < N; dr++){
                for(int dc = -M + 1; dc < M; dc++){
                    // (dr, dc)가 (0, 0)이면 오직 현재 칸만 선택 가능
                    if(dr == 0 && dc == 0){
                        long long val = board[r][c] - '0';
                        if(isPerfectSquare(val)) {
                            answer = max(answer, val);
                        }
                        continue;
                    }

                    long long cur = 0; 
                    int rr = r, cc = c;
                    for(int step = 0; step < 9; step++){
                        if(rr < 0 || rr >= N || cc < 0 || cc >= M) break;
                        
                        cur = cur * 10 + (board[rr][cc] - '0');
                        
                        if(isPerfectSquare(cur)) {
                            answer = max(answer, cur);
                        }

                        rr += dr;
                        cc += dc;
                    }
                }
            }
        }
    }

    cout << answer << "\n";
    return 0;
}