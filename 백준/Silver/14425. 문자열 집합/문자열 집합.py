import sys

input = sys.stdin.readline

n, m = map(int, input().split())
ans = [input().strip() for _ in range(n)]
check = [input().strip() for _ in range(m)]
result = 0

for i in check:
    if i in ans:
        result += 1

print(result)
