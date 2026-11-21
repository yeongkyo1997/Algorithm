#include <cstdio>
#include <vector>
using namespace std;
int main(){
    long long n,t;scanf("%lld %lld",&n,&t);
    vector<long long>x(n);long long S=0;
    for(auto&v:x){scanf("%lld",&v);S+=v;}
    const long long M=998244353;
    // answer = (t+1-S) * prod_{k=2..n} (t+1 - sum_{i>=k}(x_i-1))
    long long r=(t+1-S)%M,suf=0;
    for(long long k=n-1;k>=1;k--){suf+=x[k]-1;r=r*((t+1-suf)%M)%M;}
    printf("%lld\n",r);
}