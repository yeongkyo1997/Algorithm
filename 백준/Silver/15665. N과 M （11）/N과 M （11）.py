import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(set(map(int, input().split())))
N = len(arr)
result = []


def dfs(depth):
    if depth == M:
        print(" ".join(map(str, result)))
        return
    for i in range(N):
        result.append(arr[i])
        dfs(depth + 1)
        result.pop()


dfs(0)
