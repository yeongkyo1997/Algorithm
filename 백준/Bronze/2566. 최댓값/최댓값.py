import sys

input = sys.stdin.readline

arr = [[0] for _ in range(10)]
for i in range(1, 10):
    tmp = list(map(int, input().split()))
    arr[i].extend(tmp)
result = (0, 0, 0)

for i in range(1, 10):
    for j in range(1, 10):
        if result[0] <= arr[i][j]:
            result = (arr[i][j], i, j)
print(result[0])
print(*result[1:])
