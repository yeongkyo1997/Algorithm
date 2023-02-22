#include<cstdio>
int x, a, b;
int main() {
    for (int i = 0; i < 2; i++) {
        scanf("%d", &x);
        for (int j = 1e6; j; j /= 10) {
            int t = x / j % 10;
            a += t == 6 ? 5 * j : t*j;
            b += t == 5 ? 6 * j : t*j;
        }
    }
    printf("%d %d", a, b);
    return 0;
}