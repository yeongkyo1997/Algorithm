#include<cstdio>
#include<algorithm>
using namespace std;
int ck[101], dp[101][40], n, m, x;
int f(int d, int c) {
    if (d > n) return 0;
    if (dp[d][c] < 0) dp[d][c] = ck[d] ? f(d + 1, c) : min({ c > 2 ? f(d + 1,c - 3) : f(d + 1,c) + 10000,f(d + 3,c + 1) + 25000,f(d + 5,c + 2) + 37000 });
    return dp[d][c];
}
int main() {
    for (scanf("%d%d", &n, &m); m--;) scanf("%d", &x), ck[x] = 1;
    fill(dp[0], dp[101], -1);
    printf("%d", f(1, 0));
    return 0;
}