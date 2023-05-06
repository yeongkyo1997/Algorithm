import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))
result = []
for i in range(n):
    result.insert(i - arr[i], i + 1)

print(*result)