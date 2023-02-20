import sys

input = sys.stdin.readline

n = input().strip()
result = "".join(sorted(n, reverse=True))
if int(result) % 30 == 0:
    print(result)
else:
    print(-1)
