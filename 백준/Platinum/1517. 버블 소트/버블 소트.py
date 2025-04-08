import sys
I=sys.stdin.readline
def m(a):
 n=len(a);c=0
 if n<=1:return a,0
 mid=n//2
 l,c1=m(a[:mid])
 r,c2=m(a[mid:])
 res=[];i=j=0;c+=c1+c2
 while i<len(l)and j<len(r):
  if l[i]<=r[j]:res.append(l[i]);i+=1
  else:res.append(r[j]);j+=1;c+=len(l)-i
 res.extend(l[i:]);res.extend(r[j:])
 return res,c
N=int(I());A=list(map(int,I().split()))
_,ans=m(A)
print(ans)