import sys
sys.setrecursionlimit(2000)
R=sys.stdin.readline ;N,M,H=map(int,R().split());L=[[0]*N for _ in range(H+1)]
for _ in range(M):a,b=map(int,R().split());L[a][b]=1
A=4 
def C():
 for i in range(1,N+1): 
  k=i 
  for h in range(1,H+1): 
   k+=(L[h][k]if k<N else 0)-(L[h][k-1]if k>1 else 0)
  if k!=i:return 0 
 return 1 
def D(c,t,h,v):
 global A 
 if A<=t:return 
 if c==t: 
  if C():A=t 
  return
 for i in range(h,H+1): 
  k=v if i==h else 1 
  for j in range(k,N): 
   if L[i][j]<1 and (j<2 or L[i][j-1]<1) and (j==N-1 or L[i][j+1]<1):
    L[i][j]=1 
    D(c+1,t,i,j+1) 
    L[i][j]=0 
   if A==t:return 
if C():A=0 
else:
 for t in range(1,4): 
  D(0,t,1,1) 
  if A==t:break 
print(A if A<4 else -1)