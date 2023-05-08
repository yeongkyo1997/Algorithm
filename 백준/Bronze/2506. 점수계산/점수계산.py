import sys

input = lambda: sys.stdin.readline().rstrip()

n = int(input())

arr = list(map(int, input().split()))

cnt = 0
result = 0

for i in arr:
    if i == 1:
        cnt += 1
        result += cnt
    else:
        cnt = 0

print(result)