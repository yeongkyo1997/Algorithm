import sys

input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())

arr = [int(input()) for _ in range(N)]
arr.sort(reverse=True)
result = 0


for a in arr:
    result += K // a
    K %= a

print(result)
