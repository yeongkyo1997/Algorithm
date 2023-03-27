import sys

input = sys.stdin.readline

arr = [[0] * 100 for _ in range(100)]
N = int(input())
result = 0
for i in range(N):
    arr, b = map(int, input().split())
    for k in range(arr, arr + 10):
        for l in range(b, b + 10):
            if arr[k][l] == 0:
                result += 1
                arr[k][l] = 1
print(result)
