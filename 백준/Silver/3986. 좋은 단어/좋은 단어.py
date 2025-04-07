r=0
for i in range(int(input())):
 s=[]
 for c in input().strip():
  if s and s[-1]==c:s.pop()
  else:s.append(c)
 r+=not s
print(r)