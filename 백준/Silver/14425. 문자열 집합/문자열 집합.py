import sys

input = sys.stdin.readline

N, M = map(int, input().split())
result = [input().strip() for _ in range(N)]
check = [input().strip() for _ in range(M)]
result = 0

for i in check:
    if i in result:
        result += 1

print(result)
