import sys

input = sys.stdin.readline


n, m = map(int, input().split())

arr = []
result = 0

for i in range(m):
    arr.append(list(map(int, input().split())))

while n >= 6:
    result += min(min(a, b * 6) for a, b in arr)
    n -= 6

if n > 0:
    result += min(min(a, b * n) for a, b in arr)
    
print(result)