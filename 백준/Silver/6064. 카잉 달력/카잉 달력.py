import sys
from math import gcd

def lcm(a, b):
    return a * b // gcd(a, b)

t = int(input())
for _ in range(t):
    m, n, x, y = map(int, input().split())
    limit = lcm(m, n)
    j_found = False

    for j in range(x, limit + 1, m):
        temp = n if j % n == 0 else j % n
        if temp == y:
            print(j)
            j_found = True
            break

    if not j_found:
        print(-1)
