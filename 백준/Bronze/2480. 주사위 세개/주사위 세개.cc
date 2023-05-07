#include <stdio.h>
#define max(x, y) (x > y ? x : y)

int main() {
    int a, b, c, prize;
    scanf("%d %d %d", &a, &b, &c);
    
    if (a == b && b == c) { // 같은 눈 3개
        prize = 10000 + a * 1000;
    } else if (a == b || a == c) { // 같은 눈 2개
        prize = 1000 + a * 100;
    } else if (b == c) {
        prize = 1000 + b * 100;
    } else { // 모두 다른 눈
        prize = max(a, max(b, c)) * 100;
    }
    
    printf("%d\n", prize);
    return 0;
}