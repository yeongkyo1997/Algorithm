import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(map(int, input().split()))
result = []
visited = [False] * N


def dfs(depth):
    if depth == M:
        print(" ".join(map(str, result)))
        return
    ram = 0

    for i in range(N):
        if not visited[i] and arr[i] != ram:
            visited[i] = True
            result.append(arr[i])
            ram = arr[i]
            dfs(depth + 1)
            result.pop()
            visited[i] = False


dfs(0)
