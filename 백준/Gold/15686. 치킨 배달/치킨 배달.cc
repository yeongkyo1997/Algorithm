#include <iostream>
#include <vector>
#include <cmath>
 
#define MAX 51
#define INF 987654321
 
using namespace std;
 
vector< pair<int, int> > house;
vector< pair<int, int> > chicken;
vector< pair<int, int> > selectChi;
 
int N, M;
int ans = INF;
 
//뽑힌 치킨집들과 집과의 거리를 계산하고
//최소 거리 구하기
void calcDist(){
    int dist[house.size()];
    for(int i = 0; i < house.size(); i++){
        dist[i] = INF;
    }
    
    for(int i = 0; i < selectChi.size(); i++){
        for(int j = 0; j < house.size(); j++){
            int dis = abs(selectChi[i].first - house[j].first) + abs(selectChi[i].second - house[j].second);
            if(dist[j] > dis){
                dist[j] = dis;
            }
        }
    }
    int dap = 0;
    for(int i = 0; i < house.size(); i++){
        dap += dist[i];
    }
    if(ans > dap)
        ans = dap;
}
//재귀호출을 통해 완전 탐색하기
void select(int cnt, int k){
    //치킨집을 M개 뽑았을 때
    if(cnt == M){
        calcDist();
        return;
    }
    for(int i = k; i < chicken.size(); i++){
        selectChi.push_back(chicken[i]);
        select(cnt+1, i+1);
        selectChi.pop_back();
    }
}
 
int main(){
    cin >> N >> M;
    //집과 치킨집 받기
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            int a;
            cin >> a;
            if(a == 1)
                house.push_back(make_pair(j, i));
            if(a == 2)
                chicken.push_back(make_pair(j, i));
        }
    }
    select(0, 0);
    cout << ans << "\n";
    return 0;
}