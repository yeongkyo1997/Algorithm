#include <stdio.h>
#include <stdbool.h>

int d(int n)
{
    int sum = n;
    while (n != 0)
    {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}

int main()
{
    bool s[10001] = {false};

    for (int i = 1; i <= 10000; i++)
    {
        int index = d(i);
        if (index <= 10000)
        {
            s[index] = true;
        }
    }

    for (int i = 1; i <= 10000; i++)
    {
        if (!s[i])
        {
            printf("%d\n", i);
        }
    }

    return 0;
}