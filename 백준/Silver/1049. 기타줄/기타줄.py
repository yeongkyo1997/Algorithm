import sys

input = sys.stdin.readline


N, M = map(int, input().split())

arr = []
result = 0

for i in range(M):
    arr.append(list(map(int, input().split())))

while N >= 6:
    result += min(min(arr, b * 6) for arr, b in arr)
    N -= 6

if N > 0:
    result += min(min(arr, b * N) for arr, b in arr)
    
print(result)