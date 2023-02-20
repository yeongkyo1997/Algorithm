#include <iostream>
 
using namespace std;
string gears[1001];
int checkGears[1001];
int T;
 
void checkingRotateGear(int NumOfGear, int dir){
    checkGears[NumOfGear] = dir;
    
    //왼쪽 확인
    int nowNum = NumOfGear;
    int nowDir = dir;
    while(nowNum > 1){
        if(gears[nowNum][6] != gears[nowNum-1][2]){
            checkGears[nowNum-1] = nowDir * (-1);
        }else{
            break;
        }
        nowNum -= 1;
        nowDir = checkGears[nowNum];
    }
    //오른쪽 확인
    nowNum = NumOfGear;
    nowDir = dir;
    while (nowNum < T) {
        if(gears[nowNum][2] != gears[nowNum+1][6]){
            checkGears[nowNum+1] = nowDir * (-1);
        }else{
            break;
        }
        nowNum += 1;
        nowDir = checkGears[nowNum];
    }
}
 
void rotateGears(){
    for(unsigned int i = 1; i <= T; i++){
        //시계방향 회전
        if(checkGears[i] == 1){
            char tempLast = gears[i][7];
            string tempstr;
            tempstr += tempLast;
            for(unsigned int j = 0; j < 7; j++){
                tempstr += gears[i][j];
            }
            gears[i] = tempstr;
        }
        //반시계방향 회전
        else if(checkGears[i] == -1){
            char tempFirst = gears[i][0];
            string tempstr;
            for(unsigned int j = 1; j <= 7; j++){
                tempstr += gears[i][j];
            }
            tempstr += tempFirst;
            gears[i] = tempstr;
        }
    }
}
 
void initCheckGear(){
    for(unsigned int i = 0; i <= T; i++){
        checkGears[i] = 0;
    }
}
 
int main(){
    cin >> T;
    
    for(unsigned int i = 1; i <= T; i++){
        cin >> gears[i];
    }
    
    int K;
    cin >> K;
    
    for(unsigned int i = 0; i < K; i++){
        int NumOfGear, dir;
        cin >> NumOfGear >> dir;
        initCheckGear();
        checkingRotateGear(NumOfGear, dir);
        rotateGears();
    }
    
    int ans = 0;
    for(unsigned int i = 1; i <= T; i++){
        if(gears[i][0] == '1'){
            ans++;
        }
    }
    cout << ans << endl;
    return 0;
}