#include <iostream>
#include <sstream>
#include <string>
#include <algorithm>
#include <functional>
#include <vector>
#include <list>
#include <queue>
#include <deque>
#include <map>
#include <set>
#include <stack>
#include <math.h>
#include <memory.h>
 
using namespace std;
 
#define MAX_SIZE 100
#define INF 0x7fffffff
#define CENDL "\n"
#define ll long long
 
char table[26];
int main() {
 
    cin.tie(0);
    std::ios::sync_with_stdio(false);
 
    int n, m; cin >> n >> m;
 
    vector<pair<int, int>> play(n);
    // 경기를 개최 하는 비용을 초기화 한다.
    for (int i=0; i<n; i++) {
        int d; cin >> d;
        play[i].first = d;
        play[i].second = 0;
    }
 
    for (int i=0; i<m; i++) {
        
        // 위원 들이 갖고 있는 비용
        int d; cin >> d;
        for (int j=0; j<n; j++) {
            int cand = play[j].first;
            
            // 위원들이 갖고 있는 비용 이하 중 가장 재미있는 경기에 투표를 적산 한다.
            if (cand <= d) {
                play[j].second++;
                break;
            }
        }
    }
 
    int max_count = 0;
    int sol = 0;
    for (int i=0; i<n; i++) {
        int cand = play[i].second;
        // 가장 많은 투표를 받은 경기에 인덱스를 찾는다.
        if (cand > max_count) {
            max_count = cand;
            sol = i;
        }
    }
 
    cout << sol+1 << CENDL;
    return 0;
}
