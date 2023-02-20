#include <stdio.h>
#include <stdlib.h>

int main() {
    int max, mid, min;
    int a, b, c;

    scanf("%d %d %d", &a, &b, &c);

    max = a;
    min = a;

    if (b > max) {
        max = b;
    } else if (b < min) {
        min = b;
    }

    if (c > max) {
        max = c;
    } else if (c < min) {
        min = c;
    }

    mid = (a + b + c) - max - min;

    printf("%d %d %d", min, mid, max);
}