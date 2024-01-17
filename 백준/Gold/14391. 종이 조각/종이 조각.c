#include <stdio.h>
#include <string.h>
#include <math.h>

int N, M;
char board[5][5];
int result = 0;

void calculate(int bit)
{
    int total = 0;
    for (int x = 0; x < N; x++)
    {
        int num = 0;
        for (int y = 0; y < M; y++)
        {
            int idx = x * M + y;
            if (bit & (1 << idx))
            {
                num = num * 10 + (board[x][y] - '0');
            }
            else
            {
                if (num != 0)
                {
                    total += num;
                    num = 0;
                }
            }
        }
        if (num != 0)
        {
            total += num;
        }
    }

    for (int y = 0; y < M; y++)
    {
        int num = 0;
        for (int x = 0; x < N; x++)
        {
            int idx = x * M + y;
            if (!(bit & (1 << idx)))
            {
                num = num * 10 + (board[x][y] - '0');
            }
            else
            {
                if (num != 0)
                {
                    total += num;
                    num = 0;
                }
            }
        }
        if (num != 0)
        {
            total += num;
        }
    }

    if (total > result)
    {
        result = total;
    }
}

int main()
{
    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++)
    {
        scanf("%s", board[i]);
    }

    for (int i = 0; i < (1 << (N * M)); i++)
    {
        calculate(i);
    }

    printf("%d\n", result);
    return 0;
}