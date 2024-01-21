#include <stdio.h>

int main()
{
    int N, i, target, count = 0;
    scanf("%d", &N);

    int arr[N];
    for (i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
    }

    scanf("%d", &target);

    for (i = 0; i < N; i++)
    {
        if (arr[i] == target)
        {
            count++;
        }
    }

    printf("%d", count);

    return 0;
}