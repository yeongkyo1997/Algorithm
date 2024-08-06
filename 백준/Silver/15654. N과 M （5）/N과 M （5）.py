N, M = map(int, input().split())

arr = list(map(int, input().split()))
arr.sort()


def dfs(path, depth, flag):
    if depth == M:
        print(*path)
        return

    for i in range(N):
        if flag & (1 << i) == 0:
            path.append(arr[i])
            dfs(path, depth + 1, flag | (1 << i))
            path.pop()


dfs([], 0, 0)