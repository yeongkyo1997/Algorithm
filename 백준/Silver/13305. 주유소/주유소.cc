#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<long long> dist(N-1), price(N);
    for(int i = 0; i < N-1; i++){
        cin >> dist[i];
    }
    for(int i = 0; i < N; i++){
        cin >> price[i];
    }

    long long cost = 0;
    long long curPrice = price[0];

    for(int i = 0; i < N-1; i++){
        // i번째 구간(dist[i])을 이동하는 데 드는 비용을
        // 지금까지 가장 싼 가격 curPrice로 계산
        cost += curPrice * dist[i];

        // 다음 도시의 기름값이 더 싸다면 교체
        if(price[i+1] < curPrice)
            curPrice = price[i+1];
    }

    cout << cost << "\n";
    return 0;
}