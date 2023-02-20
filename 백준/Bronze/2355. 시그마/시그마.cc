#include <stdio.h>
 
long long int n;
long long int m;
long long int ans1, ans2;
 
int main()
{
 
    scanf("%lld %lld", &n, &m);
 
    if(n > m)
    {
        int tmp = n;
        n = m;
        m = tmp;
    }
    
    ans1 = ((n-1)*n) / 2;
    ans2 = (m*(m + 1)) / 2;
 
    printf("%lld", ans2 - ans1);
}