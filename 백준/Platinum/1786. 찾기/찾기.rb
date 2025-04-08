t=gets.chomp
p=gets.chomp
n=t.size
m=p.size
f=[0]*m
j=0
1.upto(m-1){|i|
while j>0&&p[i]!=p[j];j=f[j-1];end
j+=1 if p[i]==p[j]
f[i]=j}
r=[]
j=0
0.upto(n-1){|i|
while j>0&&t[i]!=p[j];j=f[j-1];end
j+=1 if t[i]==p[j]
if j==m;r<<i-m+2;j=f[j-1];end}
puts r.size
puts r*' '