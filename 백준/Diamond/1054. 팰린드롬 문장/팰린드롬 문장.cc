#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<string> w(N), r(N);
    for(int i=0;i<N;i++){
        cin >> w[i];
        r[i]=w[i];
        reverse(r[i].begin(), r[i].end());
    }
    // 미리 어느 단어가 자체 palindrome 인지
    vector<bool> isPal(N,false);
    for(int i=0;i<N;i++){
        isPal[i] = (w[i] == r[i]);
    }

    int M = 1<<N;
    vector<ll> dpEmpty(M,0);
    vector<unordered_map<string,ll>> dpR(M), dpL(M);
    dpEmpty[0] = 1;

    // DP
    for(int mask=0; mask<M; mask++){
        ll curE = dpEmpty[mask];
        if(curE){
            // 짝맞춤(pair) 전이
            for(int i=0;i<N;i++) if(!(mask&(1<<i))){
                for(int j=0;j<N;j++) if(i!=j && !(mask&(1<<j))){
                    int m2 = mask | (1<<i) | (1<<j);
                    const string &A = w[i], &B = r[j];
                    int la=A.size(), lb=B.size();
                    // A 가 B 의 prefix
                    if(la <= lb && B.compare(0, la, A)==0){
                        string rem = B.substr(la);
                        if(rem.empty()) dpEmpty[m2] += curE;
                        else            dpR[m2][rem] += curE;
                    }
                    // B 가 A 의 prefix
                    if(la > lb && A.compare(0, lb, B)==0){
                        string rem = A.substr(lb);
                        if(rem.empty()) dpEmpty[m2] += curE;
                        else            dpL[m2][rem] += curE;
                    }
                }
            }
        }
        // rem on RIGHT 쪽이 남은 경우 → 왼쪽 단어 추가
        for(auto &kv : dpR[mask]){
            const string &rem = kv.first;
            ll ways = kv.second;
            for(int i=0;i<N;i++) if(!(mask&(1<<i))){
                int m2 = mask | (1<<i);
                const string &A = w[i], &B = rem;
                int la=A.size(), lb=B.size();
                if(la <= lb && B.compare(0, la, A)==0){
                    string r2 = B.substr(la);
                    if(r2.empty()) dpEmpty[m2] += ways;
                    else           dpR[m2][r2] += ways;
                }
                if(la > lb && A.compare(0, lb, B)==0){
                    string r2 = A.substr(lb);
                    if(r2.empty()) dpEmpty[m2] += ways;
                    else           dpL[m2][r2] += ways;
                }
            }
        }
        // rem on LEFT 쪽이 남은 경우 → 오른쪽 단어 추가
        for(auto &kv : dpL[mask]){
            const string &rem = kv.first;
            ll ways = kv.second;
            for(int j=0;j<N;j++) if(!(mask&(1<<j))){
                int m2 = mask | (1<<j);
                const string &A = r[j], &B = rem;
                int la=A.size(), lb=B.size();
                if(la <= lb && B.compare(0, la, A)==0){
                    string r2 = B.substr(la);
                    if(r2.empty()) dpEmpty[m2] += ways;
                    else           dpL[m2][r2] += ways;
                }
                if(la > lb && A.compare(0, lb, B)==0){
                    string r2 = A.substr(lb);
                    if(r2.empty()) dpEmpty[m2] += ways;
                    else           dpR[m2][r2] += ways;
                }
            }
        }
    }

    // 남은 unused 가운데단어 개수 미리 계산
    vector<int> palUnused(M,0);
    for(int mask=0; mask<M; mask++){
        int cnt=0;
        for(int k=0;k<N;k++){
            if(!(mask&(1<<k)) && isPal[k]) cnt++;
        }
        palUnused[mask] = cnt;
    }

    // 최종 합산
    ll ans = 0;
    // 1) 짝맞춤만 끝난 짝수개(>=2)
    for(int mask=1; mask<M; mask++){
        ans += dpEmpty[mask];
    }
    // 2) center 전체 단어 삽입으로 되는 홀수개(>=1)
    //    mask=0 일 때도 palUnused[0]만큼 단일-word 카운트
    for(int mask=0; mask<M; mask++){
        if(palUnused[mask]>0 && dpEmpty[mask]>0){
            ans += dpEmpty[mask] * (ll)palUnused[mask];
        }
    }
    // 3) rem 자체가 palindrome 이면(가운데가 substring)
    auto is_pal = [&](const string &s){
        int i=0,j=s.size()-1;
        while(i<j) if(s[i++] != s[j--]) return false;
        return true;
    };
    for(int mask=0; mask<M; mask++){
        for(auto &kv : dpR[mask]){
            if(is_pal(kv.first)) ans += kv.second;
        }
        for(auto &kv : dpL[mask]){
            if(is_pal(kv.first)) ans += kv.second;
        }
    }

    cout << ans << "\n";
    return 0;
}
