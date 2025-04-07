n=int(input())
a=[list(input())for _ in range(n)]
def f():
 r=0
 for i in range(n):
  c=1
  for j in range(1,n):
   c=c+1 if a[i][j]==a[i][j-1] else 1
   r=max(r,c)
 for j in range(n):
  c=1
  for i in range(1,n):
   c=c+1 if a[i][j]==a[i-1][j] else 1
   r=max(r,c)
 return r
m=0
for i in range(n):
 for j in range(n):
  if j<n-1 and a[i][j]!=a[i][j+1]:
   a[i][j],a[i][j+1]=a[i][j+1],a[i][j]
   m=max(m,f())
   a[i][j],a[i][j+1]=a[i][j+1],a[i][j]
  if i<n-1 and a[i][j]!=a[i+1][j]:
   a[i][j],a[i+1][j]=a[i+1][j],a[i][j]
   m=max(m,f())
   a[i][j],a[i+1][j]=a[i+1][j],a[i][j]
print(m)
