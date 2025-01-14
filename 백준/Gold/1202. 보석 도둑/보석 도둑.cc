#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, K;
    cin >> N >> K;
    
    // 보석 정보를 저장할 벡터: (무게, 가격)
    vector<pair<int, int>> gems(N);
    for(int i=0; i<N; i++){
        cin >> gems[i].first >> gems[i].second;
    }
    
    // 보석을 무게 오름차순으로 정렬
    sort(gems.begin(), gems.end(), [&](const pair<int,int> &a, const pair<int,int> &b) -> bool {
        if(a.first == b.first){
            return a.second > b.second; // 무게가 같으면 가격이 높은 순
        }
        return a.first < b.first;
    });
    
    // 가방 용량을 저장할 벡터
    vector<int> bags(K);
    for(int i=0; i<K; i++){
        cin >> bags[i];
    }
    
    // 가방을 용량 오름차순으로 정렬
    sort(bags.begin(), bags.end());
    
    // 최대 힙을 사용하여 현재 가방까지 넣을 수 있는 보석의 가격을 관리
    priority_queue<int> pq;
    
    ll total = 0;
    int gem_idx = 0;
    
    for(int i=0; i<K; i++){
        int Ci = bags[i];
        // 현재 가방에 넣을 수 있는 보석들을 힙에 추가
        while(gem_idx < N && gems[gem_idx].first <= Ci){
            pq.push(gems[gem_idx].second);
            gem_idx++;
        }
        // 힙에서 가장 높은 가격의 보석을 선택
        if(!pq.empty()){
            total += pq.top();
            pq.pop();
        }
    }
    
    cout << total;
    
    return 0;
}