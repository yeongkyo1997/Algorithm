import sys

k = int(sys.stdin.readline().rstrip())
a, b, c, d = map(int, sys.stdin.readline().split())

if a == c:
    if a * k + b == c * k + d:
        print("Yes", a * k + b)
    else:
        print("No")
else:
    x = (d - b) / (a - c)
    if x == k:
        print("Yes", a * k + b)
    else:
        print("No")