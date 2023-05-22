#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>
#include <stack>
#include <cmath>

using namespace std;

int list[1002][2];
int event_num, line_num;
int dp[1002][1002];

int distance(int sep, int start, int end) {
    int x_start=list[start][0], y_start=list[start][1], x_end=list[end][0], y_end=list[end][1];

    if(start==0) {
        if(sep==1){
            x_start=y_start=1;
        } else{
            x_start=y_start=line_num;
        }
    }

    return abs(x_start-x_end) + abs(y_start-y_end);
}

int police(int index, int one, int two) {
    if(index>event_num)
        return 0;

    if(dp[one][two]!=0)
        return dp[one][two];

    int one_move=police(index+1,index,two)+distance(1,one,index);

    int two_move=police(index+1,one,index)+distance(2,two,index);

    dp[one][two]=min(one_move,two_move);

    return dp[one][two];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> line_num;
    cin >> event_num;

    for(int x=1; x<=event_num; x++){
        cin >> list[x][0] >> list[x][1];
    }

    cout << police(1,0,0) << "\n";

    int index_one=0;
    int index_two=0;

    for(int index=1; index<=event_num; index++) {
        int one_remain=distance(1,index_one,index);

        if(dp[index_one][index_two]-one_remain==dp[index][index_two]) {
            index_one=index;
            cout << "1\n";
        } else {
            index_two=index;
            cout << "2\n";
        }
    }

    return 0;
}