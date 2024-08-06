N, M = map(int, input().rstrip().split())

arr = sorted(set(map(int, input().rstrip().split())))


def dfs(path, depth, start):
    if depth == M:
        print(*path)
        return

    for i in range(start, len(arr)):
        path.append(arr[i])
        dfs(path, depth + 1, i)
        path.pop()


dfs([], 0, 0)