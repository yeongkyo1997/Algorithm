import sys

input = sys.stdin.readline

N = input().strip()
result = "".join(sorted(N, reverse=True))
if int(result) % 30 == 0:
    print(result)
else:
    print(-1)
