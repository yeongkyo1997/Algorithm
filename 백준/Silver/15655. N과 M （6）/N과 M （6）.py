import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = map(int, input().split())
arr = sorted(arr)
result = []


def dfs(num):
    if len(result) == m:
        print(" ".join(map(str, result)))
        return
    for i in range(num, n):
        result.append(arr[i])
        dfs(i + 1)
        result.pop()


dfs(0)
