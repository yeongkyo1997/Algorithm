import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = map(int, input().split())
arr = sorted(arr)
result = []


def dfs(num):
    if len(result) == M:
        print(" ".join(map(str, result)))
        return
    for i in range(num, N):
        result.append(arr[i])
        dfs(i + 1)
        result.pop()


dfs(0)
