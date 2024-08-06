N, M = map(int, input().split())


def dfs(path, depth, start):
    if depth == M:
        print(*path)
        return

    for i in range(start, N + 1):
        path.append(i)
        dfs(path, depth + 1, i)
        path.pop()


dfs([], 0, 1)