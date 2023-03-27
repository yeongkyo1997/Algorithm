#include <stdio.h>
#define MAX 42000
#define ll long long
ll arr[MAX] = {0};

ll SFI_cnt(ll k){
    ll cnt = 0;
    for(ll i = 1; i*i <= k; i++)
        cnt += arr[i]*k / (i*i);
    return cnt;
}
int main(){
    ll K;
    scanf("%lld", &K);
	
    arr[1] = 1;
    for(int i = 1; i <= MAX; i++)
        for(int j = 2*i; j <= MAX; j += i)
            arr[j] -= arr[i];
    ll first = 0, last = K*2;
    while(first < last - 1){
        ll mid = (first + last)/2;
        if(SFI_cnt(mid) < K) first = mid;
        else last = mid;
    }
    printf("%lld", last);
}