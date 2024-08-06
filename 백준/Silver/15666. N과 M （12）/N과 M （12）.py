N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr = sorted(set(arr))


def dfs(path, depth, start):
    if depth == M:
        print(*path)
        return

    for i in range(start, len(arr)):
        dfs(path + [arr[i]], depth + 1, i)


dfs([], 0, 0)