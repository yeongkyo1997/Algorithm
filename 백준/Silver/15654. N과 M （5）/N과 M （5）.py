import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = map(int, input().split())
arr = sorted(arr)
result = []


def dfs():
    if len(result) == M:
        print(" ".join(map(str, result)))
        return
    for i in range(N):
        if arr[i] not in result:
            result.append(arr[i])
            dfs()
            result.pop()


dfs()
