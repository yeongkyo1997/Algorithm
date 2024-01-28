import sys


def input(): return sys.stdin.readline().rstrip()


N, K = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
country = {i: l for i, *l in arr}
my = country[K]

result = 1
for a, b, c, d in arr:
    if a == K:
        continue
    if b > my[0]:
        result += 1
        continue
    elif c > my[1] and b == my[0]:
        result += 1
        continue
    elif d > my[2] and c == my[1] and b == my[0]:
        result += 1
        continue

print(result)