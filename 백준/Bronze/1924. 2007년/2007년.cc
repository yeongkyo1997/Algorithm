#include <stdio.h>
int main()
{
 int x, y, i, cnt = 0;
 char date[12] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

 scanf("%d %d", &x, &y);

 for (i = 1; i < x; i++)
        cnt += date[i - 1];

 cnt += y;

 switch (cnt % 7)
    {
    case 0:
        printf("SUN\n");
        break;
    case 1:
        printf("MON\n");
        break;
    case 2:
        printf("TUE\n");
        break;
    case 3:
        printf("WED\n");
        break;
    case 4:
        printf("THU\n");
        break;
    case 5:
        printf("FRI\n");
        break;
    case 6:
        printf("SAT\n");
        break;
    }
}