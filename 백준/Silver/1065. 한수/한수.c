#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool is_hansu(int num)
{
    char num_str[5];
    sprintf(num_str, "%d", num);

    if (strlen(num_str) <= 2)
    {
        return true;
    }
    else
    {
        int diff = num_str[1] - num_str[0];
        for (int i = 2; i < strlen(num_str); i++)
        {
            if (num_str[i] - num_str[i - 1] != diff)
            {
                return false;
            }
        }
    }
    return true;
}

int main()
{
    int N;
    scanf("%d", &N);

    int count = 0;
    for (int num = 1; num <= N; num++)
    {
        if (is_hansu(num))
        {
            count++;
        }
    }

    printf("%d\n", count);
    return 0;
}