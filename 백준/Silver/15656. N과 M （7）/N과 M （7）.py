import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(map(int, input().split()))
result = []


def dfs():
    if len(result) == M:
        print(" ".join(map(str, result)))
        return
    for i in arr:
        result.append(i)
        dfs()
        result.pop()


dfs()