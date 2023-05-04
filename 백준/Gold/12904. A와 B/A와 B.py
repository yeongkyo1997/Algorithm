import sys

s = sys.stdin.readline().rstrip()
t = sys.stdin.readline().rstrip()

while len(t) > len(s):
    if t[-1] == 'A':
        t = t[:-1]
    elif t[-1] == 'B':
        t = t[:-1][::-1]
    else:
        break

if s == t:
    print(1)
else:
    print(0)