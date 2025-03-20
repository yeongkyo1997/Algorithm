import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = list(map(int, input().split()))

arr.sort()

total = 0
for i in range(N + 1):
    total += sum(arr[:i])

print(total)
