import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
arr = [0]
arr += [i for i in range(1, N + 1)]

for _ in range(M):
    i, j = map(int, input().split())
    arr[i], arr[j] = arr[j], arr[i]

print(*arr[1:])