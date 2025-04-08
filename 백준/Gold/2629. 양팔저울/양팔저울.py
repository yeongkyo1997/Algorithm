input()
w=list(map(int,input().split()))
input()
b=list(map(int,input().split()))
r={0}
for x in w:r|={a+x for a in r}|{abs(a-x)for a in r}
print(*( 'Y'if c in r else'N'for c in b))