#include <cstdio>

int n, i;
long long int ans;

int main() {
    scanf("%d", &n);
    while (++i) {
        if (i == n + 1) break;
        if (i == 1) ans += 5;
        else ans += 3 * (i - 1) + 4;
        ans %= 45678;
    }
    printf("%lld\n", ans);
    return 0;
}