#include <cstdio>
#include <vector>
using namespace std;
typedef long long ll;
static char buf[1<<25];int bl=0,bp=0;
inline int gc(){if(bp==bl){bl=fread(buf,1,sizeof buf,stdin);bp=0;if(bl<=0)return -1;}return buf[bp++];}
inline ll rd(){int c=gc();while(c<'0')c=gc();ll x=0;while(c>='0'){x=x*10+c-'0';c=gc();}return x;}
vector<ll>A;vector<int>P,Q;ll best;
// i 후보 P(전위 최대), j 후보 Q(후위 최대); f가 supermodular라 최적 j가 i에 대해 단조 -> 분할정복
void solve(int l,int r,int ol,int orr){
    if(l>r)return;
    int m=(l+r)/2,p=P[m],opt=ol;ll bv=-1;
    for(int k=ol;k<=orr;k++){int q=Q[k];if(q<=p)continue;ll v=(ll)(q-p)*(A[p]+A[q]);if(v>bv){bv=v;opt=k;}}
    if(bv>best)best=bv;
    solve(l,m-1,ol,opt);solve(m+1,r,opt,orr);
}
int main(){
    int tc=rd();
    while(tc--){
        int n=rd();A.assign(n,0);for(auto&v:A)v=rd();
        P.clear();Q.clear();
        for(int i=0;i<n-1;i++)if(P.empty()||A[i]>A[P.back()])P.push_back(i);
        for(int j=n-1;j>=1;j--)if(Q.empty()||A[j]>A[Q.back()])Q.push_back(j);
        vector<int>q2(Q.rbegin(),Q.rend());Q.swap(q2);
        best=0;solve(0,(int)P.size()-1,0,(int)Q.size()-1);
        printf("%lld\n",best);
    }
}