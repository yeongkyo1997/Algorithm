import sys
R=sys.stdin.readline
n=int(R())
m=int(R())
a=[set() for _ in range(n+1)]
for _ in [0]*m:
    x,y=map(int,R().split())
    a[x]|={y}
    a[y]|={x}
i=set(a[1])
for f in a[1]:
    i|=a[f]
i.discard(1)
print(len(i))