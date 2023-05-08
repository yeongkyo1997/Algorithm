#include <stdio.h>
#include <limits.h>

int main()
{
    unsigned long long S;
    scanf("%llu", &S);

    unsigned long long i;
    for (i = 1; i <= ULLONG_MAX; i++)
    {
        if (i * (i + 1) > S * 2)
            break;
    }

    printf("%llu", i - 1);

    return 0;
}