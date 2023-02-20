import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = sorted(map(int, input().split()))
result = []
visited = [False] * n


def dfs(depth):
    if depth == m:
        print(" ".join(map(str, result)))
        return
    ram = 0
    
    for i in range(n):
        if not visited[i] and arr[i] != ram:
            visited[i] = True
            result.append(arr[i])
            ram = arr[i]
            dfs(depth + 1)
            result.pop()
            visited[i] = False


dfs(0)
