import sys

input = lambda: sys.stdin.readline().rstrip()

a, b = map(int, input().split())

if a > b:
    a, b = b, a

if b - a == 0:
    print(0)
else:
    print(b - a - 1)

print(*range(a + 1, b), end=' ')