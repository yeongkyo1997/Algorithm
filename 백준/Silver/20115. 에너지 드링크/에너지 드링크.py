import sys

sys.setrecursionlimit(10 ** 4)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())

arr = list(map(int, input().split()))

arr.sort()

result = arr[-1]

for i in arr[:-1]:
    result += i / 2

print(result)