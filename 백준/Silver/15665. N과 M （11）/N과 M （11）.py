import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = sorted(set(map(int, input().split())))
n = len(arr)
result = []


def dfs(depth):
    if depth == m:
        print(" ".join(map(str, result)))
        return
    for i in range(n):
        result.append(arr[i])
        dfs(depth + 1)
        result.pop()


dfs(0)
