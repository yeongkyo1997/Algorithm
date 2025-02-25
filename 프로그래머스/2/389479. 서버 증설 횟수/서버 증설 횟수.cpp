#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> players, int m, int k) {
    int n = players.size(); 
    vector<int> added(n, 0);  
    int totalAdd = 0;       

    for (int i = 0; i < n; i++) {
        int active = 0;
        int start = max(0, i - k + 1);
        for (int j = start; j <= i; j++) {
            active += added[j];
        }
        int required = players[i] / m; 
        
        if (active < required) {
            int need = required - active;
            totalAdd += need;
            added[i] += need;  
        }
    }
    return totalAdd;
}
