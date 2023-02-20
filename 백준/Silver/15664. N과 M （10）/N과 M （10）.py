import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = sorted(map(int, input().split()))
result = []

def dfs(depth, num):
    if depth == m:
        print(" ".join(map(str, result)))
        return
    mem = 0

    for i in range(num, n):
        if mem != arr[i]:
            result.append(arr[i])
            mem = arr[i]
            dfs(depth + 1, i + 1)
            result.pop()

dfs(0, 0)
