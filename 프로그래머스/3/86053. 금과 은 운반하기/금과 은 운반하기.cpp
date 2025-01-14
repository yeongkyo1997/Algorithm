#include <bits/stdc++.h>
using namespace std;

long long solution(int a, int b, vector<int> g, vector<int> s,
                   vector<int> w, vector<int> t) 
{
    long long left = 0;
    long long right = 400000000000000LL; 
    long long answer = right;

    while(left <= right) {
        long long mid = (left + right) / 2;

        long long sumGold = 0;    
        long long sumSilver = 0;  
        long long sumTotal = 0;   

        for(int i = 0; i < (int)g.size(); i++) {
            long long roundTrips = mid / (2LL * t[i]);
            long long remain = mid % (2LL * t[i]);
            long long partial = 0;
            if(remain >= t[i]) partial = 1;

            long long totalTrips = roundTrips + partial;

            long long capacity = totalTrips * (long long)w[i];

            sumGold += min((long long)g[i], capacity);
            sumSilver += min((long long)s[i], capacity);
            long long cityTotal = (long long)g[i] + (long long)s[i];
            sumTotal += min(cityTotal, capacity);

            if(sumGold >= a && sumSilver >= b && sumTotal >= (long long)a + b) {
            }
        }

        if(sumGold >= a && sumSilver >= b && sumTotal >= (long long)a + b) {
            answer = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return answer;
}