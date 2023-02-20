import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = sorted(set(map(int, input().split())))
n = len(arr)
result = []


def dfs(depth, num):
    if depth == m:
        print(" ".join(map(str, result)))
        return
    for i in range(num, n):
        result.append(arr[i])
        dfs(depth + 1, i)
        result.pop()


dfs(0, 0)
