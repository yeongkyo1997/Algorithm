import sys

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

arr = [int(input()) for _ in range(N)]

for _ in range(M):
    a, b = map(int, input().split())

    print(min(arr[a:b]))
