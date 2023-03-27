import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(map(int, input().split()))
result = []

def dfs(depth, num):
    if depth == M:
        print(" ".join(map(str, result)))
        return
    mem = 0

    for i in range(num, N):
        if mem != arr[i]:
            result.append(arr[i])
            mem = arr[i]
            dfs(depth + 1, i + 1)
            result.pop()

dfs(0, 0)
