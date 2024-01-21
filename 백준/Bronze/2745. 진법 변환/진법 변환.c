#include <stdio.h>
#include <stdlib.h>

int main()
{
    char N[50];
    int B;
    scanf("%s %d", N, &B);

    int result = strtol(N, NULL, B);
    printf("%d", result);

    return 0;
}