import sys


def input(): return sys.stdin.readline().rstrip()


H, W, N, M = map(int, input().split())

result = 0

for i in range(0, H, N + 1):
    for j in range(0, W, M + 1):
        result += 1

print(result)