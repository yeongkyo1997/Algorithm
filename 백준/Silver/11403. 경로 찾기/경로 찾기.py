import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

for k in range(N):
    for i in range(N):
        for j in range(N):
            if arr[i][k] == 1 and arr[k][j] == 1:
                arr[i][j] = 1

for i in range(N):
    for j in range(N):
        print(arr[i][j], end=' ')
    print()