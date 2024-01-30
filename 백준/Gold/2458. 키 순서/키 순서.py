import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

arr = [[0] * N for _ in range(N)]

for _ in range(M):
    a, b = map(int, input().split())
    arr[a - 1][b - 1] = 1


for k in range(N):
    for i in range(N):
        for j in range(N):
            if arr[i][k] == arr[k][j] == 1:
                arr[i][j] = 1

result = 0
for i in range(N):
    check = 0
    for j in range(N):
        check += arr[i][j] + arr[j][i]

    if check == N - 1:
        result += 1

print(result)