import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = map(int, input().split())
arr = sorted(arr)
result = []


def dfs():
    if len(result) == m:
        print(" ".join(map(str, result)))
        return
    for i in range(n):
        if arr[i] not in result:
            result.append(arr[i])
            dfs()
            result.pop()


dfs()
