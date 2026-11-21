#include <cstdio>
#include <algorithm>
using namespace std;
int main(){
    int T;scanf("%d",&T);
    for(int tc=1;tc<=T;tc++){
        long long P,Q,R,S,W;scanf("%lld %lld %lld %lld %lld",&P,&Q,&R,&S,&W);
        long long a=P*W,b=Q+max(0LL,W-R)*S;
        printf("#%d %lld\n",tc,min(a,b));
    }
}