import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr1 = [list(map(int, input().split())) for _ in range(n)]
arr2 = [list(map(int, input().split())) for _ in range(n)]

result = [[arr1[i][j] + arr2[i][j] for j in range(m)] for i in range(n)]
[print(*result[i]) for i in range(n)]
