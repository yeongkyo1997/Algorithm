import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

arr = [0]+[i for i in range(1, N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    arr = arr[:a] + arr[b:a - 1:-1] + arr[b + 1:]

print(*arr[1:])