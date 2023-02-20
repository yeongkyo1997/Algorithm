#include <stdio.h>
#include <math.h>
#include <bitset>
using namespace std;
const long long mod = 4294967296;
int n, pn, m, c;
bitset<100000001> d;
int main() {
    int i, j, k;
    scanf("%d", &n);
    long long res = 1;
    while (res * 2 <= n) res *= 2;
    m = sqrt((double)n);
    for (i = 3; i <= m; i += 2) {
        if (!d[i]) {
            c = i;
            while ((long long)(c) * i <= n) c *= i;
            res = (res*c) % mod; k = i + i;
            for (j = i * i; j <= n; j += k) d[j] = 1;
        }
    }
    for (; i <= n; i += 2) if (!d[i]) res = (res*i) % mod;
    printf("%lld", res);
}