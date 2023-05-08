#include <stdio.h>
#include <stdbool.h>

bool is_prime(int n) {
    if (n < 2) return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}

int main() {
    int m, n;
    scanf("%d%d", &m, &n);

    int sum = 0, min_prime = -1;
    bool found = false;
    for (int i = m; i <= n; i++) {
        if (is_prime(i)) {
            sum += i;
            if (!found || i < min_prime) {
                min_prime = i;
                found = true;
            }
        }
    }

    if (found) {
        printf("%d\n%d\n", sum, min_prime);
    } else {
        printf("-1\n");
    }

    return 0;
}