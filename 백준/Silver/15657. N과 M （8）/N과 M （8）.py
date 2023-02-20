import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = sorted(map(int, input().split()))
result = []


def dfs(num):
    if len(result) == m:
        print(" ".join(map(str, result)))
        return
    for i in range(num, n):
        result.append(arr[i])
        dfs(i)
        result.pop()


dfs(0)
