N, M = map(int, input().rstrip().split())

arr = list(map(int, input().rstrip().split()))
arr.sort()


def dfs(path: list, depth):
    if depth == M:
        print(*path)
        return

    for i in range(N):
        path.append(arr[i])
        dfs(path, depth + 1)
        path.pop()


dfs([], 0)