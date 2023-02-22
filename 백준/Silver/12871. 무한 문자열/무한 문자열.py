import sys
import math

input = sys.stdin.readline

s = input().rstrip()
ss = ""
f = input().rstrip()
ff = ""

l = math.lcm(len(s), len(f))

while len(ss) < l:
    ss += s
while len(ff) < l:
    ff += f

if ss == ff:
    print(1)
else:
    print(0)
