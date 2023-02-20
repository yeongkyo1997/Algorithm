#include <iostream>
#include <vector>
#include <queue>
using namespace std;
 
struct Shark{
    int r,c;
    int size = 2;
    int cnt = 0;
};
 
struct Fish{
    int r,c;
    int size;
};
 
int N;
int sea[20][20];
Shark shark;
vector<Fish> fishs;
int ans = 0;
bool notMove = false;
 
int dr[4] = {-1,1,0,0};
int dc[4] = {0,0,-1,1};
 
void initTargetDist(int (*dist)[20]){
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            dist[i][j] = 0;
        }
    }
}
void calcDist(int (*targetDist)[20] ){
    queue<pair<int, int>> q;
    q.push({shark.r,shark.c});
    targetDist[shark.r][shark.c] = 1;
    while(!q.empty()){
        int curR = q.front().first;
        int curC = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++){
            int nr = curR + dr[i];
            int nc = curC + dc[i];
            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;
            if(targetDist[nr][nc] != 0) continue;
            if(sea[nr][nc] > shark.size) continue;
            q.push({nr,nc});
            targetDist[nr][nc] = targetDist[curR][curC] + 1;
        }
    }
}
 
void eatFishs(){
    int targetDist[20][20];
    initTargetDist(targetDist);
    calcDist(targetDist);
    int fishNum = -1;
    int finaldist = 10000;
    for(int i = 0; i < fishs.size(); i++){
        if(fishs[i].size == -1) continue;
        if(fishs[i].size < shark.size){
            int dist = targetDist[fishs[i].r][fishs[i].c];
            if(dist == 0) continue;
            if(finaldist > dist){
                finaldist = dist;
                fishNum = i;
            }
        }
    }
    if(finaldist == 10000){
        notMove = true;
        return;
    }
    ans += (finaldist-1);
    shark.r = fishs[fishNum].r;
    shark.c = fishs[fishNum].c;
    shark.cnt++;
    if(shark.cnt == shark.size){
        shark.size++;
        shark.cnt = 0;
    }
    fishs[fishNum].size = -1;
    sea[shark.r][shark.c] = 0;
}
 
bool checkingFishEat(){
    for(int i = 0; i < fishs.size(); i++){
        if(fishs[i].size > 0){
            if(fishs[i].size - shark.size >= 0){
                continue;
            }
            return false;
        }
    }
    return true;
}
 
int main(){
    cin >> N;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> sea[i][j];
            if(sea[i][j] != 0){
                if(sea[i][j] == 9){
                    shark.r = i;
                    shark.c = j;
                    sea[i][j] = 0;
                }else{
                    Fish fish;
                    fish.r = i;
                    fish.c = j;
                    fish.size = sea[i][j];
                    fishs.push_back(fish);
                }
            }
        }
    }
    while(true){
        if(checkingFishEat() || notMove) break;
        eatFishs();
    }
    cout << ans << endl;
}