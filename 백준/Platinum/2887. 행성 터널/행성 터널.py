import sys
I=sys.stdin.readline
def f(x):
 if p[x]!=x:p[x]=f(p[x])
 return p[x]
def u(x,y):
 x,y=f(x),f(y)
 if x!=y:p[y]=x;return 1
 return 0
N=int(I())
P=[list(map(int,I().split()))+[i] for i in range(N)]
E=[]
for j in range(3):
 P.sort(key=lambda x:x[j])
 for i in range(N-1):E.append((abs(P[i][j]-P[i+1][j]),P[i][3],P[i+1][3]))
E.sort()
p=list(range(N))
c=n=0
for cost,i,j in E:
 if u(i,j):
  c+=cost;n+=1
  if n==N-1:break
print(c)