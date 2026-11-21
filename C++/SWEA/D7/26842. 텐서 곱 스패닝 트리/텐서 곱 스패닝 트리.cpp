#include <cstdio>
#include <vector>
#include <string>
using namespace std;
typedef long long ll;
static char buf[1<<25];int bl=0,bp=0;
inline int gc(){if(bp==bl){bl=fread(buf,1,sizeof buf,stdin);bp=0;if(bl<=0)return -1;}return buf[bp++];}
inline int rd(){int c=gc();while(c<'0')c=gc();int x=0;while(c>='0'){x=x*10+c-'0';c=gc();}return x;}
int par[100005],orep[100005];
int fd(int x){while(par[x]!=x)x=par[x]=par[par[x]];return x;}
int main(){
    int TC=rd();
    vector<int>U,V,W,qx,qy,qt;vector<ll>ans,dP,dz;
    string out;
    while(TC--){
        int N=rd(),Q=rd(),M=rd();
        U.resize(M);V.resize(M);W.resize(M);
        for(int i=0;i<M;i++){U[i]=rd()-1;V[i]=rd()-1;W[i]=rd();}
        int T=Q+1;ans.assign(T+1,0);dP.assign(T+2,0);dz.assign(T+2,0);
        // MST = sum_{t=0..29} (comp(가중치<=t 간선만 쓴 G x Path_i) - 1)
        for(int t=0;t<30;t++){
            for(int i=0;i<N;i++){par[i]=i;orep[i]=-1;}
            qx.clear();qy.clear();qt.clear();
            // P_r: r층 정점의 (층 1..r 안) 연결 분할. P_{r+1} = 각 클래스의 out-이웃을 한 블록으로 묶은 것
            for(int e=0;e<M;e++)if(W[e]<=t){
                if(orep[U[e]]<0)orep[U[e]]=V[e];
                else{qx.push_back(orep[U[e]]);qy.push_back(V[e]);qt.push_back(2);}
            }
            int z1=0;for(int i=0;i<N;i++)if(orep[i]<0)z1++;
            fill(dP.begin(),dP.end(),0);fill(dz.begin(),dz.end(),0);
            // 시각 r의 병합은 시각 r+1에 두 클래스 out-대표의 병합을 만든다 (병합 총 N-1회 이하)
            for(size_t h=0;h<qx.size();h++){
                int tm=qt[h];if(tm>T)break;
                int a=fd(qx[h]),b=fd(qy[h]);if(a==b)continue;
                bool na=orep[a]<0,nb=orep[b]<0;
                if(!na&&!nb){qx.push_back(orep[a]);qy.push_back(orep[b]);qt.push_back(tm+1);}
                par[b]=a;if(na)orep[a]=orep[b];
                dP[tm]--;dz[tm]+=(na&&nb?1:0)-na-nb;
            }
            // comp_i = |P_i| + sum_{r<i} z_r
            ll P=N,z=z1,zs=0;
            for(int i=1;i<=T;i++){
                if(i>=2){zs+=z;}           // z_{i-1} 누적 (갱신 전 값)
                P+=dP[i];z+=dz[i];
                if(i>=2)ans[i]+=P+zs-1;
            }
        }
        for(int i=2;i<=T;i++){out+=to_string(ans[i]);out+=(i==T?'\n':' ');}
    }
    fwrite(out.data(),1,out.size(),stdout);
}