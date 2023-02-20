#include <iostream>
#include <memory.h>
#include <cmath>
 
#define MIN(a, b)(a < b ? a : b)
#define INF 987654321
 
typedef long long ll;
 
double cost[20][20];
double dp[20][1 << 16];
int n;
std::pair<int, int> pt[20];
 
double TSP(int here, int visit) {
    double &ret = dp[here][visit];
    if (ret != -1.0)
        return ret;
 
    if (visit == (1 << n) - 1) {
        if (cost[here][0] == 0.0)
            return ret = INF;
        return ret = cost[here][0];
    }
 
    ret = INF;
    for (int i = 0; i < n; i++) {
        if (visit & (1 << i) || cost[here][i] == 0.0)
            continue;
 
        ret = MIN(ret, TSP(i, visit | (1 << i)) + cost[here][i]);
    }
 
    return ret;
}
int main() {
    scanf("%d", &n);
 
    for (int i = 0; i < n; i++)
        scanf("%d %d", &pt[i].first, &pt[i].second);
 
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cost[i][j] = sqrt(pow(pt[i].first - pt[j].first, 2) + pow(pt[i].second - pt[j].second, 2));
    
    for (int i = 0; i < 20; i++)
        for (int j = 0; j < (1 << 16); j++)
            dp[i][j] = -1.0;
 
    printf("%lf", TSP(0, 1 << 0));
    
    return 0;
}

