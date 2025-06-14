#include <bits/stdc++.h>
using namespace std;

struct Node {
    int cnt;   // 선택한 간선 개수
    int cost;  // 총 거리 합
};

struct Edge {
    int u, v, w;
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<pair<int,int>> A(N);
    for(int i=0;i<N;i++){
        cin >> A[i].first >> A[i].second;
    }
    int P, D;
    cin >> P >> D;

    // 가능한 간선 목록 추출 (거리 >= D)
    vector<Edge> edges;
    for(int i=0;i<N;i++){
        for(int j=i+1;j<N;j++){
            int w = abs(A[i].first - A[j].first)
                  + abs(A[i].second - A[j].second);
            if(w >= D){
                edges.push_back({i, j, w});
            }
        }
    }

    // DP state 개수 = 4^N = 1 << (2*N)
    int S = 1 << (2 * N);
    vector<Node> dp(S), dp2(S);

    // 초기화
    const int INF = 0x3f3f3f3f;
    for(int s = 0; s < S; s++){
        dp[s].cnt  = -1;       // 불가
        dp[s].cost = INF;
    }
    dp[0].cnt  = 0;    // 아무것도 선택 안함
    dp[0].cost = 0;

    // 각 간선에 대해 DP 전이
    for(auto &e : edges){
        // dp2 = dp
        dp2 = dp;
        int u = e.u, v = e.v, w = e.w;
        int shift_u = 2*u, shift_v = 2*v;

        for(int s = 0; s < S; s++){
            if(dp[s].cnt < 0) continue;  // 불가 상태
            // 현재 state에서 두 마을 degree 조회
            int du = (s >> shift_u) & 3;
            int dv = (s >> shift_v) & 3;
            if(du < P && dv < P){
                int ns = s + (1 << shift_u) + (1 << shift_v);
                int nc = dp[s].cnt + 1;
                int cost = dp[s].cost + w;
                // dp2[ns] 갱신
                if(nc > dp2[ns].cnt || 
                   (nc == dp2[ns].cnt && cost < dp2[ns].cost)) 
                {
                    dp2[ns].cnt  = nc;
                    dp2[ns].cost = cost;
                }
            }
        }
        // dp2 → dp
        dp.swap(dp2);
    }

    // 결과 스캔
    int bestCnt = 0, bestCost = INF;
    for(int s = 0; s < S; s++){
        int c = dp[s].cnt;
        int co = dp[s].cost;
        if(c > bestCnt || (c == bestCnt && co < bestCost)){
            bestCnt  = c;
            bestCost = co;
        }
    }
    cout << bestCnt << " " << bestCost << "\n";
    return 0;
}