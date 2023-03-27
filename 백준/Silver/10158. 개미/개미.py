import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()


w, h = map(int, input().split())
p, q = map(int, input().split())

t = int(input())

p += t

if p // w % 2 == 0:
    p %= w
else:
    p = w - (p % w)

q += t

if q // h % 2 == 0:
    q %= h
else:
    q = h - (q % h)

print(p, q)