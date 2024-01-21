import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

arr = [0]
arr += [0] * N

for _ in range(M):
    a, b, c = map(int, input().split())
    arr = arr[:a] + [c] * (b - a + 1) + arr[b + 1:]

print(*arr[1:])