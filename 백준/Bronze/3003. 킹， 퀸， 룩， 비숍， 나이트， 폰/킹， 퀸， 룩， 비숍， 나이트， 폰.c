#include <stdio.h>

int main()
{
    int input[6];
    int standard[6] = {1, 1, 2, 2, 2, 8};
    int result[6];

    for (int i = 0; i < 6; i++)
    {
        scanf("%d", &input[i]);
    }

    for (int i = 0; i < 6; i++)
    {
        result[i] = standard[i] - input[i];
        printf("%d ", result[i]);
    }

    return 0;
}