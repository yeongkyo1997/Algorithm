import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
s = set(input() for _ in range(N))

check = [input() for _ in range(M)]

result = 0
for i in check:
    if i in s:
        result += 1

print(result)