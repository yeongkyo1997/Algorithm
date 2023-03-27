import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr1 = [list(map(int, input().split())) for _ in range(N)]
arr2 = [list(map(int, input().split())) for _ in range(N)]

result = [[arr1[i][j] + arr2[i][j] for j in range(M)] for i in range(N)]
[print(*result[i]) for i in range(N)]
