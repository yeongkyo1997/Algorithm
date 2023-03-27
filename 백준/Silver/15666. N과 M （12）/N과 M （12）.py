import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(set(map(int, input().split())))
N = len(arr)
result = []


def dfs(depth, num):
    if depth == M:
        print(" ".join(map(str, result)))
        return
    for i in range(num, N):
        result.append(arr[i])
        dfs(depth + 1, i)
        result.pop()


dfs(0, 0)
