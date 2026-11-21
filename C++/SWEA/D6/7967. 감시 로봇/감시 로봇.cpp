#include <cstdio>
#include <cmath>
#include <vector>
#include <algorithm>
using namespace std;
struct Seg{double ax,ay,bx,by;};
int main(){
    int T;scanf("%d",&T);
    for(int tc=1;tc<=T;tc++){
        int N,M;scanf("%d %d",&N,&M);
        static char s[64];
        double px=0,py=0;int walls=0;
        vector<Seg> sg;vector<double> ang;
        bool wall[52][52]={};
        for(int r=0;r<N;r++){scanf("%s",s);for(int c=0;c<M;c++){
            if(s[c]=='#'){wall[r][c]=1;walls++;}
            if(s[c]=='*'){px=c+0.5;py=r+0.5;}
        }}
        // 좌표: 칸 (r,c) = [c,c+1] x [r,r+1], 로봇은 칸 중심
        auto addSeg=[&](double ax,double ay,double bx,double by){sg.push_back({ax,ay,bx,by});};
        addSeg(0,0,M,0);addSeg(M,0,M,N);addSeg(M,N,0,N);addSeg(0,N,0,0);
        vector<pair<int,int>> pts={{0,0},{M,0},{0,N},{M,N}};
        for(int r=0;r<N;r++)for(int c=0;c<M;c++)if(wall[r][c]){
            // 다른 벽과 맞닿은 변은 생략 (안쪽 변은 가림에 영향 없음)
            if(r==0||!wall[r-1][c])addSeg(c,r,c+1,r);
            if(r==N-1||!wall[r+1][c])addSeg(c,r+1,c+1,r+1);
            if(c==0||!wall[r][c-1])addSeg(c,r,c,r+1);
            if(c==M-1||!wall[r][c+1])addSeg(c+1,r,c+1,r+1);
            pts.push_back({c,r});pts.push_back({c+1,r});pts.push_back({c,r+1});pts.push_back({c+1,r+1});
        }
        for(auto&p:pts)ang.push_back(atan2(p.second-py,p.first-px));
        sort(ang.begin(),ang.end());
        vector<double> a2;for(double a:ang)if(a2.empty()||a-a2.back()>1e-12)a2.push_back(a);
        int K=a2.size();double vis=0;
        // 이웃한 임계 각도 사이 구간: 중간 광선과 가장 먼저 만나는 선분이 구간 전체의 경계
        for(int i=0;i<K;i++){
            double t1=a2[i],t2=(i+1<K?a2[i+1]:a2[0]+2*acos(-1.0));
            if(t2-t1<1e-12)continue;
            double tm=(t1+t2)/2,dx=cos(tm),dy=sin(tm),best=1e18;int bi=-1;
            for(int j=0;j<(int)sg.size();j++){
                const Seg&q=sg[j];double ex=q.bx-q.ax,ey=q.by-q.ay;
                double den=dx*ey-dy*ex;if(fabs(den)<1e-15)continue;
                double wx=q.ax-px,wy=q.ay-py;
                double t=(wx*ey-wy*ex)/den,u=(wx*dy-wy*dx)/den;
                if(t>1e-12&&u>=-1e-12&&u<=1+1e-12&&t<best){best=t;bi=j;}
            }
            const Seg&q=sg[bi];double ex=q.bx-q.ax,ey=q.by-q.ay,wx=q.ax-px,wy=q.ay-py;
            auto hit=[&](double th,double&hx,double&hy){double cx=cos(th),cy=sin(th);double den=cx*ey-cy*ex;double t=(wx*ey-wy*ex)/den;hx=t*cx;hy=t*cy;};
            double x1,y1,x2,y2;hit(t1,x1,y1);hit(t2,x2,y2);
            vis+=0.5*fabs(x1*y2-x2*y1);
        }
        double ans=(double)(N*M-walls)-vis;
        if(fabs(ans)<5e-7)ans=0;
        printf("#%d %.6f\n",tc,ans);
    }
}